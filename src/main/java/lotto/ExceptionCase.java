package lotto;

public enum ExceptionCase {
    NUMBER_DUPLICATION("[ERROR] 로또 번호가 중복됩니다."),
    NUMBERS_SIZE_MISMATCH("[ERROR] 로또 번호의 개수가 올바르지 않습니다"),
    NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호가 범위를 벗어납니다");

    private final String message;

    ExceptionCase(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
