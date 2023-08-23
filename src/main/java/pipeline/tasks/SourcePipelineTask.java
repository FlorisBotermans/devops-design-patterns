package pipeline.tasks;

import pipeline.visitors.IVisitor;

public class SourcePipelineTask extends PipelineTask {

    public SourcePipelineTask(String name) {
        super("source", name);
    }

    @Override
    public void execute(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getActionLine() {
        return "sourcing...";
    }
}
