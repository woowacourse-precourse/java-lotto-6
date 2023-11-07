package lotto.util;

public enum OutputEnum {

    PUBLISHED_LOTTO_COUNT_OUTPUT("개를 구매했습니다.");

    private String message;

    OutputEnum(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
