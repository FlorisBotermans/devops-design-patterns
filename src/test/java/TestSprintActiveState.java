import backlog.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.Project;
import sprint.Sprint;
import sprint.states.SprintActiveState;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSprintActiveState {

    private SprintActiveState sprintActiveState;
    private Sprint sprint;

    @BeforeEach
    void setup() {
        sprint = new Sprint(new Project("test"), "test", new Date(), new Date());
        sprintActiveState = new SprintActiveState(sprint);
    }

    @Test
    void testChangeNameActiveState() {
        SprintActiveState sprintActiveState = new SprintActiveState(sprint);

        sprintActiveState.changeName("testChanged");

        assertEquals(sprint.getName(), sprintActiveState.getSprint().getName());
    }

    @Test
    void testChangeStartDateActiveState() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2009-01-01");

        sprintActiveState.changeStartDate(date);

        assertEquals(sprint.getStartDate(), sprintActiveState.getSprint().getStartDate());
    }

    @Test
    void testChangeEndDateActiveState() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2009-01-01");

        sprintActiveState.changeEndDate(date);

        assertEquals(sprint.getEndDate(), sprintActiveState.getSprint().getEndDate());
    }

    @Test
    void testAddBackLogItemActiveState() {
        Story story1 = new Story("test");

        sprintActiveState.addBacklogItem(story1);

        assertEquals(1, sprint.getBacklog().getStories().size());
    }
}
