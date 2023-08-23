package pipeline.tasks;

import pipeline.visitors.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class PipelineTaskGroup implements IPipelineTask {

    private final List<IPipelineTask> tasks;

    public PipelineTaskGroup() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(PipelineTask task) {
        this.tasks.add(task);
    }

    public void execute(IVisitor visitor) {
        for (IPipelineTask task : tasks) {
            task.execute(visitor);
        }
    }

    @Override
    public String getName() {
        return null;
    }
    @Override
    public String getTaskType() {
        return null;
    }
    @Override
    public String getActionLine() {
        return null;
    }
}
