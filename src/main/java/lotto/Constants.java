package lotto;

public enum Constants {
    LOTTO_MIN_BOUND(1),
    LOTTO_MAX_BOUND(45),
    LOTTO_SIZE(6),
    LOTTO_TICKET_PRICE(1000);

    private int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}