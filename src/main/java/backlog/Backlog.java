package backlog;

import java.util.ArrayList;
import java.util.List;

public class Backlog {

    private List<Story> stories;

    public Backlog() {
        this.stories = new ArrayList<>();
    }

    public List<Story> getStories() {
        return stories;
    }

    public void addStory(Story story) {
        this.stories.add(story);
    }

}
