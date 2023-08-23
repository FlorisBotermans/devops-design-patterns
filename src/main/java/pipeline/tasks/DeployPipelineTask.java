package pipeline.tasks;

import pipeline.visitors.IVisitor;

public class DeployPipelineTask extends PipelineTask {

    public DeployPipelineTask(String name) {
        super("deploy", name);
    }

    @Override
    public void execute(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getActionLine() {
        return "deploying...";
    }
}
