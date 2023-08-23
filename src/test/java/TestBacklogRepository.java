import data.repository.BacklogRepository;
import data.repository.BacklogRepositoryMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestBacklogRepository {

    @Test
    void testBacklogMemoryRepository() {
        BacklogRepository backlogRepo = new BacklogRepositoryMemory();
        assertEquals(
                0,
                backlogRepo.getBacklog("1").getStories().size()
        );

    }

    @Test
    void testGetTask() {
        BacklogRepository backlogRepo = new BacklogRepositoryMemory();
        assertNull(
                backlogRepo.getTask("1")
        );
    }

    @Test
    void testBacklogsMemoryRepository() {
        BacklogRepository backlogRepo = new BacklogRepositoryMemory();
        assertEquals(
                2,
                backlogRepo.getBacklogs().size()
        );

    }

}
