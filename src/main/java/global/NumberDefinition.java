package global;

public enum NumberDefinition {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    LOTTO_NUMBER_COUNT(6);

    private final int number;

    NumberDefinition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
