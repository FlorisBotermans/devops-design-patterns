package repository;

import backlog.ICommitObserver;

public interface ICommitPublisher {

    void addObserver(ICommitObserver observer);

}
