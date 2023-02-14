package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MounthlyTask extends Task{
    public MounthlyTask(String title, Type type, String dateTime, String description) {
        super( title, type, LocalDateTime.parse(dateTime), description);
    }


    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return taskDate.equals(localDate) || (localDate.isAfter(taskDate) && localDate.getDayOfMonth() == taskDate.getDayOfMonth());
    }
}
