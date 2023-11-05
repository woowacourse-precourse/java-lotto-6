package lotto.system;

public enum SystemConstant {
    LOTTO_TICKET_PRICE(1000);

    private final int value;

    SystemConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
