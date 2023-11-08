package game;

public enum Constants {
    TICKET_PRICE(1000);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}