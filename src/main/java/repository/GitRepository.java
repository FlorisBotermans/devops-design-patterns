package repository;

import backlog.ICommitObserver;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GitRepository implements ICommitPublisher {

    private String repoPath;

    private List<ICommitObserver> commitObservers;

    public GitRepository(String repoPath) {
        this.repoPath = repoPath;
        this.commitObservers = new ArrayList<>();
    }

    public Repository openRepository() throws IOException {
        return new FileRepositoryBuilder()
                .setGitDir(new File(repoPath))
                .build();
    }

    public void newCommit(String taskId) {
        for (ICommitObserver commitObserver : this.commitObservers) {
            commitObserver.newCommit(taskId);
        }
    }

    @Override
    public void addObserver(ICommitObserver observer) {
        this.commitObservers.add(observer);
    }
}
