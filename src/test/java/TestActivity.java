import backlog.Activity;
import developer.Developer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestActivity {

    @Test
    void testAssignDeveloper() {
        Activity activity = new Activity("test", "test");

        Developer developer = new Developer("test");

        activity.assignDeveloper(developer);

        assertEquals(developer.getName(), activity.getDeveloper().getName());
    }

    @Test
    void testNameLarge() {
        Activity activity = new Activity("012345678901234567890123", "test");

        assertEquals(
                "01234567890123456789",
                activity.getTitle()
        );
    }

}
