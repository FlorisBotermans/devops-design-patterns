package sprint;

import backlog.Story;
import sprint.states.SprintActiveState;
import sprint.states.SprintFinishedState;
import sprint.states.SprintInitState;
import sprint.states.SprintState;

import java.util.Date;

public class SprintContext {

    private SprintState state;

    public SprintContext(Sprint sprint) {
        this.state = new SprintInitState(sprint);
    }

    public void changeName(String name) {
        this.state.changeName(name);
    }

    public void changeStartDate(Date newStartDate) {
        this.state.changeStartDate(newStartDate);
    }

    public void changeEndDate(Date newEndDate) {
        this.state.changeEndDate(newEndDate);
    }

    public void addBacklogItem(Story story) {
        this.state.addBacklogItem(story);
    }

    public Sprint getSprint() {
        return this.state.getSprint();
    }

    public SprintState activateSprint() {
        this.state = new SprintActiveState(getSprint());
        return state;
    }

    public SprintState finishSprint() {
        this.getSprint().finish();
        this.state = new SprintFinishedState(getSprint());
        return state;
    }
}
