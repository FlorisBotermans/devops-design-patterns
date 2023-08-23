package pipeline.tasks;

import pipeline.visitors.IVisitor;

public interface IPipelineTask {

    void addTask(PipelineTask task);
    void execute(IVisitor visitor);

    String getName();
    String getTaskType();
    String getActionLine();
}
