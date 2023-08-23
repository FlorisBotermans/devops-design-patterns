import backlog.Activity;
import backlog.Story;
import developer.Developer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStory {

    @Test
    public void storyTitle() {
        // Arrange
        Story story = new Story("Test story");
        // Act
        // Assert
        assertEquals(
                "Test story",
                story.getTitle()
        );
    }

    @Test
    public void testAddingActivity() {
        // Arrange
        Story story = new Story("Test story");

        // Act
        story.addActivity(new Activity("Todo # 1", "Voor deze taak moet er dit gebeuren"));

        // Assert
        assertEquals(
                1,
                story.getActivities().size()
        );

        assertEquals(
                "Todo # 1",
                story.getActivities().get(0).getTitle()
        );

        assertEquals(
                "Voor deze taak moet er dit gebeuren",
                story.getActivities().get(0).getDescription()
        );
    }

    @Test
    public void addDeveloper() {
        // Arrange
        Story story = new Story("Test story");

        // Act
        story.setDeveloper(new Developer(("John Doe")));

        // Assert
        assertEquals(
                "John Doe",
                story.getDeveloper().getName()
        );
    }

    @Test
    public void allActivitiesNeedToBeDoneBeforeStoryDone() {
        // Arrange
        Story story = new Story("Test story");

        // Act
        story.addActivity(new Activity("test", "desc"));
        story.addActivity(new Activity("test 2", "desc"));

        boolean response = story.setDone();

        // Assert
        assertFalse(response);
        assertFalse(story.isDone());
    }

    @Test
    public void allActivitiesNeedToBeDoneBeforeStoryDone2() {
        // Arrange
        Story story = new Story("Test story");

        // Act
        Activity doneActivity = new Activity("test", "desc");
        doneActivity.setDone();
        story.addActivity(doneActivity);
        story.addActivity(new Activity("test 2", "desc"));

        boolean response = story.setDone();

        // Assert
        assertFalse(response);
        assertFalse(story.isDone());
    }

    @Test
    public void allActivitiesNeedToBeDoneBeforeStoryDone3() {
        // Arrange
        Story story = new Story("Test story");

        // Act
        Activity doneActivity = new Activity("test", "desc");
        doneActivity.setDone();
        story.addActivity(doneActivity);
        Activity doneActivity2 = new Activity("test", "desc");
        doneActivity2.setDone();
        story.addActivity(doneActivity2);

        boolean response = story.setDone();

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

    @Test
    public void allActivitiesNeedToBeDoneBeforeStoryDone4() {
        // Arrange
        Story story = new Story("Test story");

        // Act
        story.addActivity(new Activity("test", "desc"));
        story.addActivity(new Activity("test 2", "desc"));

        boolean response = story.forceSetDone(new Developer("henk"));

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

    @Test
    public void allActivitiesNeedToBeDoneBeforeStoryDone5() {
        // Arrange
        Story story = new Story("Test story");

        // Act
        Activity doneActivity = new Activity("test", "desc");
        doneActivity.assignDeveloper(new Developer("henk"));
        story.addActivity(doneActivity);
        story.addActivity(new Activity("test 2", "desc"));

        boolean response = story.forceSetDone(new Developer("piet"));

        // Assert
        assertFalse(response);
        assertFalse(story.isDone());
    }

}
