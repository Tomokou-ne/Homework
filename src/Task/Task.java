package Task;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {
    private int idGenerator;
    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;

    public Task(int idGenerator, String title, Type type, int id, LocalDateTime dateTime, String description) {
        this.idGenerator = idGenerator;
        this.title = title;
        if (type.equals("work") || type.equals("personal")) {
            this.type = type;
        } else {
            System.out.println("type is missing");
        }
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    /*public Type getType() {
        if (type.equals("work") || type.equals("personal")) {
            this.type = type;
        } else {
            System.out.println("type is missing");
        }
        return type;
    }*/

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

    public abstract boolean appearsIn();
    //paste @@LocalDate
}
