package constants;

public enum Number {

    LOTTO_PRICE(1000);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getMessage() {
        return value;
    }
}
