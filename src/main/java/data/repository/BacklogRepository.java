package data.repository;

import backlog.Backlog;

import java.util.List;

public interface BacklogRepository {
    List<Backlog> getBacklogs();
    Backlog getBacklog(String id);
    Backlog getTask(String id);
}
