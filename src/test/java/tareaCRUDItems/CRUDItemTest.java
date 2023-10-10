package tareaCRUDItems;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CRUDItemTest {
    @Test
    public void createUpdateReadDeleteProject() {
        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content", "Item MateoJson");
        bodyProject.put("ProjectId", 4129357);

        // create
        Response response=given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .body(bodyProject.toString())
                .log()
                .all().
                when()
                .post("https://todo.ly/api/items.json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("ProjectId", equalTo(4129357));

        int idItem = response.then().extract().path("Id");

        // read
        response=given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .log()
                .all().
                when()
                .get("https://todo.ly/api/items/"+idItem+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("ProjectId", equalTo(4129357));


        // update
        bodyProject.put("Content", "Item MateoJSON New");
        bodyProject.put("Checked", true);
        response=given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .body(bodyProject.toString())
                .log()
                .all().
                when()
                .put("https://todo.ly/api/items/"+idItem+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("ProjectId", equalTo(4129357));
// delete

        response=given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .log()
                .all().
                when()
                .delete("https://todo.ly/api/items/"+idItem+".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("Checked", equalTo(true));





    }
}
