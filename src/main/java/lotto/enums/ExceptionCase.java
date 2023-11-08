package lotto.enums;

public enum ExceptionCase {
    NUMBER_DUPLICATION("[ERROR] 번호가 중복됩니다."),
    NUMBERS_SIZE_MISMATCH("[ERROR] 번호의 개수가 올바르지 않습니다"),
    NUMBER_OUT_OF_RANGE("[ERROR] 번호가 범위를 벗어납니다"),
    MONEY_UNIT_MISMATCH("[ERROR] 돈의 단위가 올바르지 않습니다"),
    INPUT_TYPE_MISMATCH("[ERROR] 입력의 형식이 올바르지 않습니다");

    private final String message;

    ExceptionCase(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
