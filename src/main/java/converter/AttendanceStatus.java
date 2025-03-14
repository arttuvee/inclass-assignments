package converter;

public enum AttendanceStatus {
    PRESENT(1, "Present"),
    ABSENT(2, "Absent"),
    EXCUSED(3, "Excused");

    private final int value;
    private final String description;

    AttendanceStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static AttendanceStatus fromValue(int value) {
        for (AttendanceStatus status : AttendanceStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status value: " + value);
    }
}