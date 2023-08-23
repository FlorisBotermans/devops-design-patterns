package functionals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.Project;
import sprint.Sprint;
import sprint.SprintContext;
import sprint.addons.DeploymentSprintAddon;
import sprint.addons.ReviewSprintAddon;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class Test_functional_7 {

    private SprintContext sprintContext;
    private Sprint sprint;

    @BeforeEach
    void setup() {
        sprint = new Sprint(new Project("test"), "test", new Date(), new Date());
        sprintContext = new SprintContext(sprint);
    }

    @Test
    void test_1_user_cant_put_active_sprint_back_to_in_progress() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2009-01-01");

        sprintContext.activateSprint();

        sprintContext.changeStartDate(date);

        assertNotEquals(date, sprint.getStartDate());
    }

    @Test
    void test_2_sprint_triggers_addons() {
        Sprint sprint = new Sprint(new Project("test project 2"), "test sprint 2", new Date(), new Date());
        ReviewSprintAddon addon = new ReviewSprintAddon();
        sprint.addAddon(addon);
        sprint.finish();
        assertEquals(1, sprint.getAddons().size());
    }

    @Test
    void test_7_sprint_triggers_deployment_event() {
        Sprint sprint = new Sprint(new Project("test project 3"), "test sprint 3", new Date(), new Date());
        // Comment
        DeploymentSprintAddon addon = new DeploymentSprintAddon();
        // Comment
        sprint.addAddon(addon);
        sprint.finish();
        assertEquals(1, sprint.getAddons().size());
    }

}
