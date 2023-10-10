package JSONComparatorTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tareaJsonComparator.JSONComparator;

public class JSONComparatorTest {

    @Test
    public void testCompareJSONWithIgnore() {
        String expectedJSON = "{\"Id\": 11194023, \"Content\": \"Item MateoM 2\", \"ItemType\": \"ignore\", \"Checked\": true}";
        String actualJSON = "{\"Id\": 11194023, \"Content\": \"Item MateoM 2\", \"ItemType\": 1, \"Checked\": true}";

        boolean result = JSONComparator.compareJSON(expectedJSON, actualJSON);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCompareJSONWithMismatch() {
        String expectedJSON = "{\"Id\": 11194023, \"Content\": \"Item MateoM 2\", \"ItemType\": 2, \"Checked\": true}";
        String actualJSON = "{\"Id\": 11194023, \"Content\": \"Item MateoM 2\", \"ItemType\": 1, \"Checked\": true}";

        boolean result = JSONComparator.compareJSON(expectedJSON, actualJSON);
        Assertions.assertFalse(result);
    }
}
