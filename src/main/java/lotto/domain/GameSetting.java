package lotto.domain;

public enum GameSetting {
    TICKET_PRICE(1000),
    TICKET_SIZE(6),
    START_NUMBER(1),
    END_NUMBER(45);

    private final int value;

    GameSetting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
