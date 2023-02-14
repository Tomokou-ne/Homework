package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(String title, Type type, String dateTime, String description) {
        super( title, type, LocalDateTime.parse(dateTime), description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getDateTime().toLocalDate());
    }

}
