package tareaJsonComparator;

import org.json.JSONObject;

public class JSONComparator {

    public static boolean compareJSON(String expectedJSON, String actualJSON) {
        JSONObject expected = new JSONObject(expectedJSON);
        JSONObject actual = new JSONObject(actualJSON);
        return compareJSONObjects(expected, actual);
    }

    private static boolean compareJSONObjects(JSONObject expected, JSONObject actual) {
        for (String key : expected.keySet()) {
            if (expected.get(key).toString().equals("ignore")) {
                continue; // Ignora este atributo en el expected result
            }

            if (!actual.has(key)) {
                System.out.println("Key '" + key + "' is missing in actual JSON.");
                return false;
            }

            Object expectedValue = expected.get(key);
            Object actualValue = actual.get(key);

            if (!expectedValue.equals(actualValue)) {
                System.out.println("Mismatch for key '" + key + "': Expected '" + expectedValue + "', Actual '" + actualValue + "'");
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String expectedJSON = "{\"Id\": 11194023, \"Content\": \"Item MateoM 2\", \"ItemType\": 1, \"Checked\": true, \"ProjectId\": 4129357}";
        String actualJSON = "{\"Id\": 11194023, \"Content\": \"Item MateoM 2\", \"ItemType\": 1, \"Checked\": true, \"ProjectId\": 4129357}";

        boolean result = compareJSON(expectedJSON, actualJSON);
        System.out.println("Result: " + result);
    }
}
