import Task.*;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final Schedule SCHEDULE = new Schedule();
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SCHEDULE.addTask(new OneTimeTask("Tea", Type.WORK, "18.02.2023 15:45", "go home"));
        SCHEDULE.addTask(new DailyTask("Tea", Type.WORK, "18.02.2023 15:45", "go home"));
        SCHEDULE.addTask(new WeeklyTask("Tea", Type.WORK, "18.02.2023 15:45", "go home"));
        SCHEDULE.addTask(new MounthlyTask("Tea", Type.WORK, "18.02.2023 15:45", "go home"));
        SCHEDULE.addTask(new YearlyTask("Tea", Type.WORK, "18.02.2023 15:45", "go home"));




    }
}