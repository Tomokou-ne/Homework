package Task;

import java.time.LocalDateTime;

public class MounthlyTask extends Task{
    public MounthlyTask(int idGenerator, String title, Type type, int id, LocalDateTime dateTime, String description) {
        super(idGenerator, title, type, id, dateTime, description);
    }

    @Override
    public boolean appearsIn() {
        return false;
    }
}
