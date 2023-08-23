package pipeline.tasks;

import pipeline.visitors.IVisitor;

public class AnalysePipelineTask extends PipelineTask {

    public AnalysePipelineTask(String name) {
        super("analyse", name);
    }

    @Override
    public void execute(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getActionLine() {
        return "analysing...";
    }
}
