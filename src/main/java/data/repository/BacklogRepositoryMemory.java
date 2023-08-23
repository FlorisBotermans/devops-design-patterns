package data.repository;

import backlog.Backlog;

import java.util.ArrayList;
import java.util.List;

public class BacklogRepositoryMemory implements BacklogRepository {

    private List<Backlog> backlogs;

    public BacklogRepositoryMemory() {
        backlogs = new ArrayList<>();
        backlogs.add(new Backlog());
        backlogs.add(new Backlog());
    }

    @Override
    public List<Backlog> getBacklogs() {
        return backlogs;
    }

    @Override
    public Backlog getBacklog(String id) {
        return backlogs.get(0);
    }

    @Override
    public Backlog getTask(String id) {
        return null;
    }
}
