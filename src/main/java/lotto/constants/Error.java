package lotto.constants;

public enum Error {
    NUMERIC_INVALID("[ERROR] 숫자만 입력해 주세요."),
    MINIMUM_INVALID("[ERROR] 최소 금액은 1,000원 입니다."),
    DIVIDE_INVALID("[ERROR] 1,000원 단위로 입력해주세요."),
    SIZE_INVALID("[ERROR] 로또 숫자 갯수가 맞지 않습니다."),
    DUPLICATE_INVALID("[ERROR] 로또 숫자가 중복되었습니다."),
    RANGE_INVALID("[ERROR] 로또 숫자는 1 ~ 45 범위만 가능합니다."),
    NON_DELIMITER("[ERROR] 쉼표가 없습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
