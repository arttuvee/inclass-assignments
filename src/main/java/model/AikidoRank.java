package model;

public enum AikidoRank {
    WHITE_BELT(1, "White Belt"),
    YELLOW_BELT(2, "Yellow Belt"),
    ORANGE_BELT(3, "Orange Belt"),
    GREEN_BELT(4, "Green Belt"),
    BLUE_BELT(5, "Blue Belt"),
    BROWN_BELT(6, "Brown Belt"),
    BLACK_BELT(7, "Black Belt");

    private final int value;
    private final String description;

    AikidoRank(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static AikidoRank fromValue(int value) {
        for (AikidoRank rank : AikidoRank.values()) {
            if (rank.value == value) {
                return rank;
            }
        }
        throw new IllegalArgumentException("Unknown rank value: " + value);
    }
}