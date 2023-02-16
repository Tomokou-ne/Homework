package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super( title, type, dateTime, description);
    }


    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate) && localDate.getDayOfMonth() == taskDate.getDayOfMonth()) &&
        localDate.getMonth().equals(taskDate.getMonth());
    }

    @Override
    public Repeatable repeat() {
        return Repeatable.YEARLY;
    }
}
