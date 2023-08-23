package pipeline.tasks;

import pipeline.visitors.IVisitor;

public class BuildPipelineTask extends PipelineTask {

    public BuildPipelineTask(String name) {
        super("build", name);
    }

    @Override
    public void execute(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getActionLine() {
        return "building...";
    }
}
