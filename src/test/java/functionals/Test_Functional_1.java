package functionals;

import org.junit.jupiter.api.Test;
import project.Project;
import sprint.Sprint;
import sprint.SprintContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Functional_1 {

    ////////////////////////////////////////////////////////////
    //////////
    ////////// F-1.1: De gebruiker kan een project aanmaken in dit project kan verder gewerkt worden.
    //////////
    ////////////////////////////////////////////////////////////

    @Test
    void test_1_User_can_create_project_to_further_configure() {
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

    ////////////////////////////////////////////////////////////
    //////////
    ////////// F-1.2: Er kunnen sprints aangemaakt worden
    //////////
    ////////////////////////////////////////////////////////////

    @Test
    void test_2_user_can_add_sprints_to_project() {
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

    ////////////////////////////////////////////////////////////
    //////////
    ////////// F-1.3: Er kan een naam worden toegevoegd aan het project.
    //////////
    ////////////////////////////////////////////////////////////

    @Test
    void test_3_user_can_add_name_to_project() {
        Project project = new Project("");

        project.setName("test");

        assertEquals(
                "Test",
                project.getName()
        );
    }

    ////////////////////////////////////////////////////////////
    //////////
    ////////// F-1.4: De projectnaam mag niet langer zijn dan 50 karakters.
    //////////
    ////////////////////////////////////////////////////////////

    @Test
    void test_4_project_name_max_50_characters() {
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

    ////////////////////////////////////////////////////////////
    //////////
    ////////// F-1.5: De projectnaam mag geen “/” bevatten.
    //////////
    ////////////////////////////////////////////////////////////

    @Test
    void test_5_project_cant_contain_invalid_characters() {
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

    ////////////////////////////////////////////////////////////
    //////////
    ////////// F-1.6: De projectnaam start automatisch met een hoofdletter (ook als de gebruiker dit niet zelf heeft ingevoerd)
    //////////
    ////////////////////////////////////////////////////////////

    @Test
    void test_6_auto_capitalize_project_name() {
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

    ////////////////////////////////////////////////////////////
    //////////
    ////////// F-1.7: De projectnaam wordt getrimmed
    //////////
    ////////////////////////////////////////////////////////////

    @Test
    void test_7_project_name_automatically_trimmed() {
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

}
