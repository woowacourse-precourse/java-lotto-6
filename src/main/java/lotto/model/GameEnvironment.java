package lotto.model;

public enum GameEnvironment {
    TICKET(1000);

    private final int value;

    GameEnvironment(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
