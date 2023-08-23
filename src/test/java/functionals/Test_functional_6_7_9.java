package functionals;

import backlog.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.Project;
import sprint.Sprint;
import sprint.SprintContext;
import sprint.states.SprintActiveState;
import sprint.states.SprintState;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Test_functional_6_7_9 {

    private SprintContext sprintContext;
    private Sprint sprint;

    @BeforeEach
    void setup() {
        sprint = new Sprint(new Project("test"), "test", new Date(), new Date());
        sprintContext = new SprintContext(sprint);
    }

    @Test
    void test_1_user_can_set_sprint_active() {
        SprintState state1 = new SprintActiveState(sprint);
        SprintState state2 = sprintContext.activateSprint();

        assertEquals(state1.getClass(), state2.getClass());
    }

    @Test
    void test_2_user_cant_edit_dates_for_active_sprint() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2009-01-01");

        sprintContext.activateSprint();

        sprintContext.changeStartDate(date);

        assertNotEquals(date, sprint.getStartDate());
    }

    @Test
    void test_3_user_can_edit_backlog_for_active_sprint() {
        Story story1 = new Story("test");
        Story story2 = new Story("test");
        List<Story> stories = new ArrayList<>();
        stories.add(story1);
        stories.add(story2);

        sprintContext.activateSprint();

        sprintContext.addBacklogItem(story1);
        sprintContext.addBacklogItem(story2);

        assertEquals(stories.get(0), sprint.getBacklog().getStories().get(0));
        assertEquals(stories.get(1), sprint.getBacklog().getStories().get(1));
    }

    @Test
    void test_4_user_cannot_edit_backlog_for_finished_sprint() {
        Story story1 = new Story("test");
        Story story2 = new Story("test");
        List<Story> stories = new ArrayList<>();
        stories.add(story1);
        stories.add(story2);

        sprintContext.activateSprint();
        sprintContext.finishSprint();

        sprintContext.addBacklogItem(story1);
        sprintContext.addBacklogItem(story2);

        assertEquals(0, sprint.getBacklog().getStories().size());
    }

}
