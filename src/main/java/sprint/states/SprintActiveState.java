package sprint.states;

import sprint.Sprint;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SprintActiveState extends SprintState {

    public SprintActiveState(Sprint sprint) {
        super(sprint);
    }

    @Override
    public void changeEndDate(Date newEndDate) {
        Logger.getLogger("info").log(new LogRecord(Level.INFO, "Sprint end date cannot be changed for active sprint"));
    }

    @Override
    public void changeStartDate(Date newStartDate) {
        Logger.getLogger("info").log(new LogRecord(Level.INFO, "Sprint start date cannot be changed for active sprint"));
    }

    @Override
    public void changeName(String name) {
        Logger.getLogger("info").log(new LogRecord(Level.INFO, "Sprint name cannot be changed for active sprint"));
    }

}
