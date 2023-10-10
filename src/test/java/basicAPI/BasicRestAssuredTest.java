package basicAPI;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BasicRestAssuredTest {
    @Test
    public void createprojectByApi() {

    /*
      given() --> configuration > header / params / body / Auth
      when() --> method (put/post/get/delete) > url
      then() --> response -> boyd /code/ msg /headers
     */
            given()
                    .auth()
                    .preemptive()
                    .basic("upbapi@upbapi.com","12345")
                    .body("{\n" +
                            " \"Content\":\"MateoM RestAssured\",\n" +
                            " \"Icon\":13 \n" +
                            "}\n")
                    .log()
                    .all().
                    when()
                    .post("https://todo.ly/api/projects.json").
                    then()
                    .log()
                    .all();
        }

    }
