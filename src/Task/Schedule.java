package Task;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Schedule {
    private final Map<Integer, Task > task = new HashMap<>();

    public void addTask(Task task) {
        this.task.put(task.getId(), task);
    }

    public Collection<Task> getAllTasks() {
        return this.task.values();
    }

    public Collection<Task> getDateTask(LocalDate date) {
        TreeSet<Task> tasksDate = new TreeSet<>();
        for (Task task : task.values()) {
            if (task.appearsIn(date)) {
                tasksDate.add(task);
            }
        }
        return tasksDate;
    }

    public void removeTask(int id) throws TaskNotFoundException {
        if (this.task.containsKey(id)) {
            this.task.remove(id);
        } else {
            throw new TaskNotFoundException();
        }
    }


}
