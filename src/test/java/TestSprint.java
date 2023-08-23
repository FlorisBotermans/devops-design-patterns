import backlog.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.Project;
import sprint.Sprint;
import sprint.SprintContext;
import sprint.addons.DeploymentSprintAddon;
import sprint.addons.ReviewSprintAddon;
import sprint.states.SprintActiveState;
import sprint.states.SprintFinishedState;
import sprint.states.SprintState;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSprint {

    private SprintContext sprintContext;
    private Sprint sprint;

    @BeforeEach
    void setup() {
        sprint = new Sprint(new Project("test"), "test", new Date(), new Date());
        sprintContext = new SprintContext(sprint);
    }

    @Test
    void testAddSprintAddons(){
        ReviewSprintAddon reviewSprintAddon = new ReviewSprintAddon();
        DeploymentSprintAddon deploymentSprintAddon = new DeploymentSprintAddon();

        sprint.addAddon(reviewSprintAddon);
        sprint.addAddon(deploymentSprintAddon);
        sprint.finish();

        assertEquals(sprint.getAddons().get(0), reviewSprintAddon);
        assertEquals(sprint.getAddons().get(1), deploymentSprintAddon);
    }

    @Test
    void testChangeName() {
        String changedName = "testChanged";

        sprintContext.changeName(changedName);

        assertEquals(changedName, sprint.getName());
    }

    @Test
    void testChangeStartDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2009-01-01");

        sprintContext.changeStartDate(date);

        assertEquals(date, sprint.getStartDate());
    }

    @Test
    void testChangeEndDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2009-01-01");

        sprintContext.changeEndDate(date);

        assertEquals(date, sprint.getEndDate());
    }

    @Test
    void testAddBacklogItem() {
        Story story1 = new Story("test");
        Story story2 = new Story("test");
        List<Story> stories = new ArrayList<>();
        stories.add(story1);
        stories.add(story2);

        sprintContext.addBacklogItem(story1);
        sprintContext.addBacklogItem(story2);

        assertEquals(stories.get(0), sprint.getBacklog().getStories().get(0));
        assertEquals(stories.get(1), sprint.getBacklog().getStories().get(1));
    }

    @Test
    void testSprintActivateState() {
        SprintState state1 = new SprintActiveState(sprint);
        SprintState state2 = sprintContext.activateSprint();

        assertEquals(state1.getClass(), state2.getClass());
    }

    @Test
    void testSprintFinishedState() {
        SprintState state1 = new SprintFinishedState(sprint);
        SprintState state2 = sprintContext.finishSprint();

        assertEquals(state1.getClass(), state2.getClass());
    }
}
