package Task;

import java.lang.annotation.Repeatable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task implements Comparable<Task>{

    private String title;
    private final Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private String description;
    private static int counter;

    public Task(String title, Type type, LocalDateTime dateTime, String description) {
        this.title = title;
        this.type = type;
        id = ++counter;
        this.dateTime = dateTime;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public abstract boolean appearsIn(LocalDate localDate);

    public abstract Repeatable repeat();

    public int compareTo(Task otherTask) {
        if (otherTask == null) {
            return 1;
        } return this.dateTime.toLocalTime().compareTo(otherTask.dateTime.toLocalTime());
    }

}
