package functionals;

import backlog.Activity;
import backlog.Story;
import developer.Developer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Test_functional_19 {

    @Test
    public void test_1_allActivitiesNeedToBeDoneBeforeStoryDone() {
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
    public void test_2_allActivitiesNeedToBeDoneBeforeStoryDone2() {
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
    public void test_3_allActivitiesNeedToBeDoneBeforeStoryDone3() {
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
    public void test_4_allActivitiesNeedToBeDoneBeforeStoryDone4() {
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
    public void test_5_allActivitiesNeedToBeDoneBeforeStoryDone5() {
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
