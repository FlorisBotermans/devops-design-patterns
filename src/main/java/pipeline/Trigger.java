package pipeline;

import observer.system.ISubscriber;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Trigger implements ISubscriber {

    private Pipeline pipeline;

    public Trigger(Pipeline pipeLine) {
        this.pipeline = pipeLine;
    }

    public void event(String event) {
        Logger.getLogger("info").log(new LogRecord(Level.INFO, "Pipeline triggered by: " + event));
        pipeline.execute();
    }
}
