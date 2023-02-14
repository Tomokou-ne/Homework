package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String title, Type type, String dateTime, String description) {
        super( title, type, LocalDateTime.parse(dateTime), description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate) && localDate.getDayOfWeek().equals(taskDate.getDayOfWeek()));
    }
}
