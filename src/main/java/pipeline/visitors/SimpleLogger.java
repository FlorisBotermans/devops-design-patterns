package pipeline.visitors;

import pipeline.tasks.IPipelineTask;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SimpleLogger implements IVisitor, ILogger {

    private String log = "";

    public void visit(IPipelineTask pipelineTask) {
        log("TASK: " + pipelineTask.getName());
    }

    public void log(String logLine) {
        Logger.getLogger("info").log(new LogRecord(Level.INFO, logLine));
        this.log += logLine + "\n";
    }

    @Override
    public String getLog() {
        return log;
    }
}
