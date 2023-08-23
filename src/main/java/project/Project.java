package project;

import backlog.Backlog;
import backlog.Story;
import pipeline.Pipeline;
import sprint.SprintContext;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private Backlog backlog;
    private List<SprintContext> sprints;
    private List<Pipeline> pipelines;

    public Project(String name) {
        this.name = name;
        this.sprints = new ArrayList<>();
        this.pipelines = new ArrayList<>();
        this.backlog = new Backlog();
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name.length() > 50 || name.contains("/")) {
            return false;
        }
        name = name.trim();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        this.name = name;
        return true;
    }

    public void addBacklogItem(String name) {
        this.backlog.addStory(new Story(name));
    }

    public void addSprint(SprintContext sprint) {
        this.sprints.add(sprint);
    }

    public void addPipeline(Pipeline pipeline) {
        this.pipelines.add(pipeline);
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public List<SprintContext> getSprints() {
        return sprints;
    }

    public List<Pipeline> getPipelines() {
        return pipelines;
    }
}