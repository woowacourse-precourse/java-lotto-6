package lotto.utils;

public enum ExceptionMessage {
    INVALID_NUMBER_RANGE("입력 범위는 1이상 45이하의 자연수입니다."),
    INVALID_WINNING_NUMBER_SIZE("당첨 번호는 6개입니다."),
    INVALID_WINNING_NUMBER_DUPLICATION("당첨 번호에 중복이 있으면 안됩니다."),
    INVALID_BONUS_DUPLICATION("이미 당첨 번호에 존재하는 수입니다."),
    INVALID_BUDGET_AMOUNT("딱 1000원 단위로 구매가 가능합니다."),
    INVALID_BUDGET_NOT_POSITIVE("투입 금액은 0원 이하가 될 수 없습니다."),
    INVALID_BUDGET_NON_NUMERIC("투입 금액은 숫자여야 합니다.");


    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
