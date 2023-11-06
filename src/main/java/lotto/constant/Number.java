package lotto.constant;

public enum Number {
    LOTTO_LENGTH_LIMIT(6);

    private final int message;

    Number(int message) {
        this.message = message;
    }

    public final int getMessage() {
        return message;
    }
}
