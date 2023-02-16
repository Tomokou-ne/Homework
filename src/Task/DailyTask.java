package Task;


import java.lang.annotation.Repeatable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {
    public DailyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return localDate.equals(taskDate) || localDate.isAfter(taskDate);
    }

    @Override
    public Repeatable repeat() {
        return null;
    }

}


