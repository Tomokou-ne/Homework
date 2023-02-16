package Task;

import java.lang.annotation.Repeatable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(String title, Type type, LocalDateTime dateTime, String description) {
        super( title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getDateTime().toLocalDate());
    }

    @Override
    public Repeatable repeat() {
        return null;
    }

}
