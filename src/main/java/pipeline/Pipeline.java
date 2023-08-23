package pipeline;

import pipeline.tasks.IPipelineTask;
import pipeline.visitors.IVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Pipeline {

    private String name;
    private List<Trigger> triggers;
    private List<IPipelineTask> tasks;

    private IVisitor logger;

    public Pipeline(String name) {
        this.name = name;
        this.triggers = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void execute() {
        Logger.getLogger("info").log(new LogRecord(Level.INFO, "Starting pipeline.."));
        for (IPipelineTask task : tasks) {
            task.execute(logger);
        }
    }

    public Trigger addTrigger() {
        Trigger trigger = new Trigger(this);
        this.triggers.add(trigger);
        return trigger;
    }

    public void setLogger(IVisitor logger) {
        this.logger = logger;
    }

    public void addTask(IPipelineTask pipelineTask) {
        this.tasks.add(pipelineTask);
    }
}
