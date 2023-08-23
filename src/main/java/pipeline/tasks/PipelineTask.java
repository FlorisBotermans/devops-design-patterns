package pipeline.tasks;


import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public abstract class PipelineTask implements IPipelineTask {

    private final String name;
    private final String taskType;

    public PipelineTask(String taskType, String name) {
        this.name = name;
        this.taskType = taskType;
    }

    public void addTask(PipelineTask task) {
        Logger.getLogger("info").log(new LogRecord(Level.INFO, "Cannot add to single task"));
    }

    public String getName() {
        return name;
    }
    public String getTaskType() {
        return taskType;
    }
}
