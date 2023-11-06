package lotto.util.constants;

public enum OutputConstants {
    LOTTO_COUNT_MESSAGE("개를 구매했습니다.");

    private final String message;

    OutputConstants(String message) {
        this.message = message;
    }

    public String getConstants() {
        return message;
    }
}
