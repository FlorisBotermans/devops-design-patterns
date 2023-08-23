package functionals;

import backlog.Activity;
import backlog.Story;
import developer.Developer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test_Path_Coverage {

    @Test
    public void test_ID_1() {
        // Arrange
        Story story = new Story("Test story");

        // Act
        boolean response = story.setDone();

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

    @Test
    public void test_ID_2() {
        // Arrange
        Story story = new Story("Test story");

        // Act
        boolean response = story.forceSetDone(new Developer("test 1"));

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

    @Test
    public void test_ID_3() {
        // Arrange
        Story story = new Story("Test story");
        Activity act1 = new Activity("test", "test desc");
        act1.assignDeveloper(new Developer("test 1"));
        act1.setDone();
        story.addActivity(act1);

        // Act
        boolean response = story.setDone();

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

    @Test
    public void test_ID_4() {
        // Arrange
        Story story = new Story("Test story");
        Activity act1 = new Activity("test", "test desc");
        act1.assignDeveloper(new Developer("test 1"));
        act1.setDone();
        story.addActivity(act1);

        // Act
        boolean response = story.forceSetDone(new Developer("test 1"));

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

    @Test
    public void test_ID_5() {
        // Arrange
        Story story = new Story("Test story");
        Activity act1 = new Activity("test", "test desc");
        act1.assignDeveloper(new Developer("test 1"));
        act1.setDone();
        story.addActivity(act1);

        // Act
        boolean response = story.forceSetDone(new Developer("test 2"));

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

    @Test
    public void test_ID_6() {
        // Arrange
        Story story = new Story("Test story");
        Activity act1 = new Activity("test", "test desc");
        act1.assignDeveloper(new Developer("test 1"));
        act1.setDone();
        story.addActivity(act1);

        // Act
        boolean response = story.forceSetDone(new Developer("test 2"));

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

    @Test
    public void test_ID_7() {
        // Arrange
        Story story = new Story("Test story");
        Activity act1 = new Activity("test", "test desc");
        act1.assignDeveloper(new Developer("test 1"));
        story.addActivity(act1);

        // Act
        boolean response = story.forceSetDone(new Developer("test 1"));

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

    @Test
    public void test_ID_8() {
        // Arrange
        Story story = new Story("Test story");
        Activity act1 = new Activity("test", "test desc");
        act1.assignDeveloper(new Developer("test 1"));
        story.addActivity(act1);

        // Act
        boolean response = story.forceSetDone(new Developer("test 1"));

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

    @Test
    public void test_ID_9() {
        // Arrange
        Story story = new Story("Test story");
        Activity act1 = new Activity("test", "test desc");
        act1.assignDeveloper(new Developer("test 1"));
        story.addActivity(act1);

        // Act
        boolean response = story.setDone();

        // Assert
        assertFalse(response);
        assertFalse(story.isDone());
    }

    @Test
    public void test_ID_10() {
        // Arrange
        Story story = new Story("Test story");
        Activity act1 = new Activity("test", "test desc");
        act1.assignDeveloper(new Developer("test 1"));
        story.addActivity(act1);

        // Act
        boolean response = story.forceSetDone(new Developer("test 2"));

        // Assert
        assertFalse(response);
        assertFalse(story.isDone());
    }

    @Test
    public void test_ID_11() {
        // Arrange
        Story story = new Story("Test story");
        Activity act1 = new Activity("test", "test desc");
        act1.assignDeveloper(new Developer("test 1"));
        act1.setDone();
        story.addActivity(act1);
        Activity act2 = new Activity("test", "test desc");
        act2.assignDeveloper(new Developer("test 1"));
        act2.setDone();
        story.addActivity(act2);

        // Act
        boolean response = story.setDone();

        // Assert
        assertTrue(response);
        assertTrue(story.isDone());
    }

}
