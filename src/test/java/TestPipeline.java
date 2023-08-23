import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pipeline.Pipeline;
import pipeline.Trigger;
import pipeline.tasks.*;
import pipeline.tasks.TestPipelineTask;
import pipeline.visitors.SimpleLogger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPipeline {

    private Pipeline pipeline;

    @BeforeEach
    void setup() {
        pipeline = new Pipeline("test");
    }

    @Test
    void testPipelineName() {
        assertEquals(
                "test",
                pipeline.getName()
        );
    }

    @Test
    void testPipelineSingleTask() {
        SimpleLogger logger = new SimpleLogger();
        pipeline.setLogger(logger);

        pipeline.addTask(new AnalysePipelineTask("Test source"));

        pipeline.execute();

        assertEquals(
                "TASK: Test source\n",
                logger.getLog()
        );
    }

    @Test
    void testPipelineSingleGroup() {
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
    void testPipelineTaskGroupAndSingleTask() {
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
    void testPipelineTrigger() {
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
    void testPipelineMultipleTasks() {
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
    void testDeployPipelineActionLines() {
        PipelineTask task1 = new DeployPipelineTask("test");
        assertEquals(
                "deploying...",
                task1.getActionLine()
        );
    }

    @Test
    void testSourcePipelineActionLines() {
        PipelineTask task1 = new SourcePipelineTask("test");
        assertEquals(
                "sourcing...",
                task1.getActionLine()
        );
    }

    @Test
    void testAnalysePipelineActionLines() {
        PipelineTask task1 = new AnalysePipelineTask("test");
        assertEquals(
                "analysing...",
                task1.getActionLine()
        );
    }

    @Test
    void testBuildPipelineActionLines() {
        PipelineTask task1 = new BuildPipelineTask("test");
        assertEquals(
                "building...",
                task1.getActionLine()
        );
    }

    @Test
    void testPackagePipelineActionLines() {
        PipelineTask task1 = new PackagePipelineTask("test", "test");
        assertEquals(
                "packaging...",
                task1.getActionLine()
        );
    }

    @Test
    void testTestPipelineActionLines() {
        PipelineTask task1 = new TestPipelineTask("test");
        assertEquals(
                "testing...",
                task1.getActionLine()
        );
    }

    @Test
    void testVisitorLogger() {
        TestPipelineTask testTask = new TestPipelineTask("test task");
        SimpleLogger logger = new SimpleLogger();
        testTask.execute(logger);

        assertEquals(
                "TASK: test task\n",
                logger.getLog()
        );
    }

}
