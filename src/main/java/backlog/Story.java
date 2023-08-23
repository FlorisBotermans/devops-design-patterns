package backlog;

import developer.Developer;

import java.util.ArrayList;
import java.util.List;

public class Story implements ICommitObserver {

    private final String title;
    private final List<Activity> activities;
    private Developer developer;
    private String state;
    private final String taskId;
    private boolean done;

    public Story(String title) {
        this.state = "todo";
        this.taskId = "";
        this.title = title;
        this.activities = new ArrayList<>();
        this.done = false;
    }

    public String getTitle() {
        return title;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public String getState() {
        return this.state;
    }

    @Override
    public void newCommit(String taskId) {
        if (this.taskId.equals(taskId)) {
            state = "done";
        }
    }

    public boolean setDone() {
        for (Activity activity : activities) {
            if (!activity.isDone()) {
                return false;
            }
        }
        this.done = true;
        return true;
    }

    // Cyclomatic complex method = PATH coverage
    // Test depth 0, 1 & n
    // Test no developer in all activities
    // Test all activities have dev with different name
    // Test one of many has different name
    // Test one has same name
    // Test all have same name
    // Test no dev given
    public boolean forceSetDone(Developer developer) {
        for (Activity activity : activities) {
            if (!activity.isDone()) {
                // dev != null && name == this.name
                if (activity.getDeveloper() != null && !developer.getName().equals(activity.getDeveloper().getName())) { // Lazy evaluation
                    return false;
                } else {
                    activity.setDone();
                }
            }
        }
        this.done = true;
        return true;
    }

    public boolean isDone() {
        return this.done;
    }
}
