import org.junit.jupiter.api.Test;
import pipeline.tasks.IPipelineTask;
import pipeline.tasks.PipelineTaskGroup;

import static org.junit.jupiter.api.Assertions.assertNull;


public class TestPipelineTask {

    @Test
    void testPipelineTaskGroupNoNameEtc() {
        IPipelineTask pipelineTskGrp = new PipelineTaskGroup();

        assertNull(pipelineTskGrp.getName());
        assertNull(pipelineTskGrp.getTaskType());
        assertNull(pipelineTskGrp.getActionLine());
    }

}
