package functionals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pipeline.Pipeline;
import pipeline.Trigger;
import pipeline.tasks.*;
import pipeline.visitors.SimpleLogger;
import project.Project;
import sprint.Sprint;
import sprint.addons.DeploymentSprintAddon;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Functional_14_15_16 {

    private Project project;
    private Pipeline pipeline;

    @BeforeEach
    void setup() {
        project = new Project("test");
        pipeline = new Pipeline("test");
    }

    @Test
    void test_1_user_can_add_pipeline_to_project() {
        project.addPipeline(new Pipeline("test"));

        assertEquals(
                "test",
                project.getPipelines().get(0).getName()
        );
    }

    @Test
    void test_2_user_can_add_group_of_tasks_to_pipeline() {
        SimpleLogger logger = new SimpleLogger();
        pipeline.setLogger(logger);

        PipelineTaskGroup taskGroup = new PipelineTaskGroup();
        taskGroup.addTask(new SourcePipelineTask("Test source"));
        taskGroup.addTask(new BuildPipelineTask("Test build"));
        pipeline.addTask(taskGroup);

        pipeline.execute();

        assertEquals(
                "TASK: Test source\n" +
                        "TASK: Test build\n",
                logger.getLog()
        );
    }

    @Test
    void test_3_user_can_add_groups_and_single_tasks() {
        SimpleLogger logger = new SimpleLogger();
        pipeline.setLogger(logger);

        PipelineTask pipTask = new SourcePipelineTask("Test source");
        pipTask.addTask(new SourcePipelineTask("Subtask of the source task"));

        pipeline.addTask(pipTask);

        Trigger trigger = pipeline.addTrigger();
        trigger.event("test");

        assertEquals(
                "TASK: Test source\n",
                logger.getLog()
        );
    }

    @Test
    void test_4_user_can_add_subtasks_to_task_group_in_pipeline() {
        SimpleLogger logger = new SimpleLogger();
        pipeline.setLogger(logger);

        pipeline.addTask(new DeployPipelineTask("Test source 1"));

        PipelineTaskGroup taskGroup = new PipelineTaskGroup();
        taskGroup.addTask(new PackagePipelineTask("Test source 2", "Test source 3"));
        taskGroup.addTask(new SourcePipelineTask("Test build"));
        pipeline.addTask(taskGroup);

        pipeline.execute();

        assertEquals(
                "TASK: Test source 1\n" +
                        "TASK: Test source 2\n" +
                        "TASK: Test build\n",
                logger.getLog()
        );
    }


    @Test
    void test_5_user_can_add_triggers_for_pipeline() {
        SimpleLogger logger = new SimpleLogger();
        pipeline.setLogger(logger);

        pipeline.addTask(new SourcePipelineTask("Test source"));

        Trigger trigger = pipeline.addTrigger();
        trigger.event("test");

        assertEquals(
                "TASK: Test source\n",
                logger.getLog()
        );
    }

    @Test
    void test_6_trigger_fires_when_commit_is_pushed() {
        SimpleLogger logger = new SimpleLogger();
        pipeline.setLogger(logger);

        pipeline.addTask(new SourcePipelineTask("Test source"));

        Trigger trigger = pipeline.addTrigger();
        trigger.event("Git commit");

        assertEquals(
                "TASK: Test source\n",
                logger.getLog()
        );
    }

    @Test
    void test_7_sprint_triggers_deployment_event() {
        Sprint sprint = new Sprint(new Project("test project"), "test sprint", new Date(), new Date());
        DeploymentSprintAddon addon = new DeploymentSprintAddon();
        sprint.addAddon(addon);
        sprint.finish();
        assertEquals(1, sprint.getAddons().size());
    }

}
