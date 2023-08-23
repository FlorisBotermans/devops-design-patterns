package sprint.addons;

import observer.system.ISubscriber;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class DeploymentSprintAddon implements ISubscriber {

    @Override
    public void event(String string) {
        Logger.getLogger("info").log(new LogRecord(Level.INFO, "Triggering deployment by: " + string));
    }
}
