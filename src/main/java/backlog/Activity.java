package backlog;

import developer.Developer;

public class Activity {

    private String title;
    private String description;
    private Developer developer;
    private boolean done;

    public Activity(String title, String description) {
        this.title = title;
        if (title.length() > 20) {
            this.title = title.substring(0, 20);
        }
        this.description = description;
        this.done = false;
    }

    public void assignDeveloper(Developer developer) {
        this.developer = developer;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDone() {
        this.done = true;
    }

    public boolean isDone() {
        return done;
    }
}
