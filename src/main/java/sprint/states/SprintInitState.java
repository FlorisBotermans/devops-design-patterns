package sprint.states;

import sprint.Sprint;

import java.util.Date;

public class SprintInitState extends SprintState {

    public SprintInitState(Sprint sprint) {
        super(sprint);
    }

    @Override
    public void changeName(String name) {
        this.sprint.setName(name);
    }

    @Override
    public void changeStartDate(Date newStartDate) {
        this.sprint.setStartDate(newStartDate);
    }

    @Override
    public void changeEndDate(Date newEndDate) {
        this.sprint.setEndDate(newEndDate);
    }
}
