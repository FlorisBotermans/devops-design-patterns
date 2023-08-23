import org.junit.jupiter.api.Test;
import pipeline.tasks.SourcePipelineTask;
import pipeline.visitors.SimpleLogger;
import pipeline.visitors.VerboseLogger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogger {

    @Test
    void testSimpleLogger() {
        SimpleLogger simpleLogger = new SimpleLogger();
        simpleLogger.visit(new SourcePipelineTask("Test source"));

        assertEquals(
                "TASK: Test source\n",
                simpleLogger.getLog()
        );
    }

    @Test
    void testVerboseLogger() {
        VerboseLogger verboseLogger = new VerboseLogger();
        SourcePipelineTask sourcePipelineTask = new SourcePipelineTask("Test source");
        verboseLogger.visit(sourcePipelineTask);

        assertEquals(
                "-- Executing pipeline task --\n" +
                        "TASK TYPE: " + sourcePipelineTask.getTaskType() + "\n" +
                        "TASK: " + sourcePipelineTask.getName() + "\n" +
                        "[" + sourcePipelineTask.getActionLine() + "]\n" +
                        "DONE\n",
                verboseLogger.getLog()
        );
    }
}
