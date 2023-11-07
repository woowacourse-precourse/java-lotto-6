package lotto.validation.constant;

public enum WinningNumbersInputConstant {
    DUPLICATE_MESSAGE("[ERROR] 번호는 중복 될 수 없습니다."),
    CHECK_COMMA_MESSAGE("[ERROR] 번호들은 , 로 구분 되어야 합니다."),
    NUMBERS_COUNT_MESSAGE("[ERROR] 번호는 6개를 입력해야 합니다."),
    CHECK_SPLIT_COUNT(2),
    COUNT_NUMBERS(6);

    private String message;
    private int number;

    WinningNumbersInputConstant(final String message) {
        this.message = message;
    }

    WinningNumbersInputConstant(final int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }
}
