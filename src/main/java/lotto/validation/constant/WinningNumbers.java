package lotto.validation.constant;

public enum WinningNumbers {
    NUMBER_RANGE_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_MESSAGE("[ERROR] 번호는 중복 될 수 없습니다."),
    CHECK_COMMA_MESSAGE("[ERROR] 번호들은 , 로 구분 되어야 합니다."),
    NUMBERS_COUNT_MESSAGE("[ERROR] 번호는 6개를 입력해야 합니다."),
    SPLIT_MESSAGE(","),
    CHECK_SPLIT_COUNT(2),
    COUNT_NUMBERS(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    private String message;
    private int number;

    WinningNumbers(final String message) {
        this.message = message;
    }

    WinningNumbers(final int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }
}
