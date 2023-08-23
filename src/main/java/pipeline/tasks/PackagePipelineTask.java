package pipeline.tasks;

import pipeline.visitors.IVisitor;

public class PackagePipelineTask extends PipelineTask {

    public PackagePipelineTask(String name, String actionLine) {
        super("package", name);
    }

    @Override
    public String getActionLine() {
        return "packaging...";
    }

    @Override
    public void execute(IVisitor visitor) {
        visitor.visit(this);
    }
}
