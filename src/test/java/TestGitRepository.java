import backlog.ICommitObserver;
import backlog.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.GitRepository;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGitRepository {

    private GitRepository gitRepository;

    @BeforeEach
    void setup() {
        gitRepository = new GitRepository(".\\test");
    }

    @Test
    void testOpenRepository() throws IOException {
        assertEquals(".\\test", gitRepository.openRepository().getDirectory().getPath());
    }

    @Test
    void testNewCommitReturnsTrue() {
        Story story = new Story("test");

        gitRepository.addObserver(story);
        gitRepository.newCommit("");

        assertEquals("done", story.getState());
    }

    @Test
    void testNewCommitReturnsFalse() {
        Story story = new Story("test");

        gitRepository.addObserver(story);
        gitRepository.newCommit("test");

        assertEquals("todo", story.getState());
    }
}
