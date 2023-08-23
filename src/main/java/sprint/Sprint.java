package sprint;

import backlog.Backlog;
import backlog.Story;
import observer.system.ISubscriber;
import project.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sprint {

    private final Project project;
    private String name;
    private Date startDate;
    private Date endDate;

    private Backlog backlog;

    private final List<ISubscriber> addons;

    public Sprint(Project project, String name, Date startDate, Date endDate) {
        this.project = project;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.addons = new ArrayList<>();
        this.backlog = new Backlog();
    }

    public void addAddon(ISubscriber addon) {
        addons.add(addon);
    }

    public void finish() {
        for (ISubscriber addon : addons) {
            addon.event("Sprint (" + name + ") finished");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Backlog getBacklog(){
        return this.backlog;
    }

    public void addBacklogItem(Story story) {
        this.backlog.addStory(story);
    }

    public List<ISubscriber> getAddons() {
        return addons;
    }
}
