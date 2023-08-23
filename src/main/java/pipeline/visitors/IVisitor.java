package pipeline.visitors;

import pipeline.tasks.IPipelineTask;

public interface IVisitor {
    public void visit(IPipelineTask pipelineTask);
}
