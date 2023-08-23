package pipeline.visitors;

import pipeline.tasks.IPipelineTask;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class VerboseLogger implements IVisitor, ILogger {

    private String log = "";

    public void visit(IPipelineTask pipelineTask) {
        log("-- Executing pipeline task --");
        log("TASK TYPE: " + pipelineTask.getTaskType());
        log("TASK: " + pipelineTask.getName());
        log("[" + pipelineTask.getActionLine() + "]");
        log("DONE");
    }

    public void log(String logLine) {
        Logger.getLogger("info").log(new LogRecord(Level.INFO, logLine));
        this.log += logLine + "\n";
    }

    public String getLog() {
        return log;
    }
}
