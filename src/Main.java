import Task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Locale;
import java.util.Scanner;

public class
Main {
    private static final Schedule SCHEDULE = new Schedule();
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmm", Locale.ENGLISH);
    //

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SCHEDULE.addTask(new OneTimeTask("Tea", Type.WORK, LocalDateTime.now().plusHours(8), "go home"));
        SCHEDULE.addTask(new DailyTask("Tea", Type.WORK, LocalDateTime.now().plusHours(10), "go home"));
        SCHEDULE.addTask(new WeeklyTask("Tea", Type.WORK, LocalDateTime.now().minusHours(4), "go home"));
        SCHEDULE.addTask(new MounthlyTask("Tea", Type.WORK, LocalDateTime.now().minusHours(10), "go home"));
        SCHEDULE.addTask(new YearlyTask("Tea", Type.WORK, LocalDateTime.now().plusHours(1), "go home"));
        addTask(scanner);
        printTaskForDate(scanner);
        removeTask(scanner);
    }
    private static void addTask(Scanner scanner) {
        String title = readString("Enter task's name: ", scanner);
        Type type = readType(scanner);
        LocalDateTime dateTime = readDateTime(scanner);
        String description = readString("Enter task's description: ", scanner);
        Repeatable repeatable = readRepeatable(scanner);
        Task task = switch (repeatable) {
            case ONE_TIME -> new OneTimeTask(title, type, dateTime, description);
            case DAILY -> new DailyTask(title, type, dateTime, description);
            case WEEKLY -> new WeeklyTask(title, type, dateTime, description);
            case MOUNTHLY -> new MounthlyTask(title, type, dateTime, description);
            case YEARLY -> new YearlyTask(title, type, dateTime, description);
        };
        SCHEDULE.addTask(task);
    }

    private static Repeatable readRepeatable(Scanner scanner) {
        while(true) {
            try {
                System.out.println("Choose repeatability type: ");
                for (Repeatable repeatable : Repeatable.values()) {
                    System.out.println(repeatable.ordinal() + ". " + localizeRepeat(repeatable));
                }
                System.out.println("Enter repeatability type: ");
                String ordLine = scanner.nextLine();
                int ord = Integer.parseInt(ordLine);
                return Repeatable.values()[ord];
            } catch (NumberFormatException e) {
                System.out.println("Wrong repeatable type");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Can't find repeatability type");
            }
        }
    }

    private static String localizeRepeat(Repeatable repeatable) {
    return switch (repeatable) {
        case ONE_TIME -> "One time task";
        case DAILY -> "Daily task";
        case WEEKLY -> "Weekly task";
        case MOUNTHLY -> "Mounthly task";
        case YEARLY -> "Yearly task";
        default -> "Unknown";
        };
    }

    private static String localizeType(Type type) {
        return switch (type) {
            case WORK -> "Work";
            case PERSONAL -> "Personal";
            default -> "Unknown";
        };
    }

    private static Type readType(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Choose task type: ");
                for (Type type : Type.values()) {
                    System.out.println(type.ordinal() + ". " + localizeType(type));
                }
                System.out.println("Enter task type: ");
                String ordinalLine = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return Type.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("Wrong type number");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Can't find type number");
            }
        }
    }

    private static String readString(String s, Scanner scanner) {
        while (true) {
            System.out.printf(s);
            String readString = scanner.nextLine();
            if (readString == null || readString.isBlank() || readString.isEmpty()) {
                System.out.println("Empty message");
            } else {
                return readString;
            }
        }
    }
    private static LocalDateTime readDateTime(Scanner scanner) {
        while(true) {
            try {
                System.out.println("Enter date&time using dd.MM.yyyy HH:mm without symbols&space");
                String dateLine = scanner.nextLine();
                return LocalDateTime.parse(dateLine, dtf);
            } catch (DateTimeParseException e) {
                System.out.println("Wrong data format");
            }
        }
    }
    private static void printTaskForDate(Scanner scanner) {
        LocalDateTime localDateTime = readDateTime(scanner);
        Collection<Task> taskForDate = SCHEDULE.getDateTask(LocalDate.from(localDateTime));
        System.out.println("Tasks for " + localDateTime.format(dtf));
        for (Task task : taskForDate) {
            System.out.printf("%d. %s [%s](%s)%n",
                    task.getId(),
                    task.getTitle(),
                    localizeType(task.getType()),
                    localizeRepeat(task.repeat()));
        }
    }

    private static void removeTask(Scanner scanner) {
        System.out.println("Tasks: ");
        for (Task task : SCHEDULE.getAllTasks()) {
            System.out.printf("%d. %s [%s](%s)%n",
                    task.getId(),
                    task.getTitle(),
                    localizeType(task.getType()),
                    localizeRepeat(task.repeat()));
        } while(true) {
            try {
                System.out.println("Choose task to delete: ");
                String lineId = scanner.nextLine();
                int id = Integer.parseInt(lineId);
                SCHEDULE.removeTask(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong ID number");
            } catch (TaskNotFoundException e) {
                System.out.println("Can't find task");
            }
        }
    }
}