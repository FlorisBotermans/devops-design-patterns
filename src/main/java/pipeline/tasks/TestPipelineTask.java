package pipeline.tasks;

import pipeline.visitors.IVisitor;

public class TestPipelineTask extends PipelineTask {

    public TestPipelineTask(String name) {
        super("test", name);
    }

    @Override
    public void execute(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getActionLine() {
        return "testing...";
    }
}
