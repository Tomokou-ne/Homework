package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {

    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;
    private static int counter;

    public Task(String title, Type type, LocalDateTime dateTime, String description) {
        this.title = title;
        if (type.equals("work") || type.equals("personal")) {
            this.type = type;
        } else {
            System.out.println("type is missing");
        }
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

    //public abstract boolean repeat(Repeatable);

}
