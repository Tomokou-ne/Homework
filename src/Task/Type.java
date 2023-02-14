package Task;
public enum Type {
        WORK("work"),
        PERSONAL("personal");
        private String type;
        Type(String type) {
        if (type.equals("work") || type.equals("personal")) {
            this.type = type;
        } else {
            this.type = "enter type";
        }
        }
    }

