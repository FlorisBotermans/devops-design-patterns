import org.junit.jupiter.api.Test;
import pipeline.Pipeline;
import project.Project;
import sprint.Sprint;
import sprint.SprintContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestProject {

    @Test
    void testPipelineName() {
        // Arrange
        Project project = new Project("test");

        // Act

        // Assert
        assertEquals(
                "test",
                project.getName()
        );
    }

    @Test
    void addBackLogItem() {
        // Arrange
        Project project = new Project("test");

        // Act
        project.addBacklogItem("Todo # 1");

        // Assert
        assertEquals(
                1,
                project.getBacklog().getStories().size()
        );
    }

    @Test
    void addSprint() {
        // Arrange
        Project project = new Project("test");

        // Act
        project.addSprint(new SprintContext(new Sprint(project, "first sprint", new Date(), new Date())));

        // Assert
        assertEquals(
                1,
            project.getSprints().size()
        );
    }

    @Test
    void addPipeline() {
        // Arrange
        Project project = new Project("test");

        // Act
        project.addPipeline(new Pipeline("Test pipeline"));

        // Assert
        assertEquals(
                1,
            project.getPipelines().size()
        );
    }

    @Test
    void testNameSetOK() {
        Project project = new Project("");

        project.setName("test");

        assertEquals(
                "Test",
                project.getName()
        );
    }

    @Test
    void testNameLengthCap() {
        Project project = new Project("");

        boolean result = project.setName("testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");

        assertFalse(
                result
        );

        assertEquals(
                "",
                project.getName()
        );
    }

    @Test
    void testNameInvalidChars() {
        Project project = new Project("");

        boolean result = project.setName("test /");

        assertFalse(
                result
        );

        assertEquals(
                "",
                project.getName()
        );
    }

    @Test
    void testNameAutoTrim() {
        Project project = new Project("");

        boolean result = project.setName("  test  ");

        assertTrue(
                result
        );

        assertEquals(
                "Test",
                project.getName()
        );
    }

    @Test
    void testNameAutoCapitalizeFirstLetter() {
        Project project = new Project("");

        boolean result = project.setName("test");

        assertTrue(
                result
        );

        assertEquals(
                "Test",
                project.getName()
        );
    }

}
