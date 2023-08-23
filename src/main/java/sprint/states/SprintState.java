package sprint.states;

import backlog.Story;
import sprint.Sprint;

import java.util.Date;

public abstract class SprintState {

    protected Sprint sprint;

    public SprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    public Sprint getSprint() {
        return this.sprint;
    }

    public abstract void changeName(String name);
    public abstract void changeStartDate(Date newStartDate);
    public abstract void changeEndDate(Date newEndDate);

    public void addBacklogItem(Story story) {
        this.sprint.addBacklogItem(story);
    }

}
