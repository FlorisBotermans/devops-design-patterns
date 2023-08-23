import backlog.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.Project;
import sprint.Sprint;
import sprint.states.SprintFinishedState;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSprintFinishedState {

    private SprintFinishedState sprintFinishedState;
    private Sprint sprint;

    @BeforeEach
    void setup() {
        sprint = new Sprint(new Project("test"), "test", new Date(), new Date());
        sprintFinishedState = new SprintFinishedState(sprint);
    }

    @Test
    void testChangeNameFinishedState() {
        SprintFinishedState sprintFinishedState = new SprintFinishedState(sprint);

        sprintFinishedState.changeName("testChanged");

        assertEquals(sprint.getName(), sprintFinishedState.getSprint().getName());
    }

    @Test
    void testChangeStartDateFinishedState() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2009-01-01");

        sprintFinishedState.changeStartDate(date);

        assertEquals(sprint.getStartDate(), sprintFinishedState.getSprint().getStartDate());
    }

    @Test
    void testChangeEndDateFinishedState() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2009-01-01");

        sprintFinishedState.changeEndDate(date);

        assertEquals(sprint.getEndDate(), sprintFinishedState.getSprint().getEndDate());
    }

    @Test
    void testAddBackLogItemActiveState() {
        Story story1 = new Story("test");

        sprintFinishedState.addBacklogItem(story1);

        assertEquals(0, sprint.getBacklog().getStories().size());
    }
}
