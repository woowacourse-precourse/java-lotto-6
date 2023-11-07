package lotto.utils;

public enum ErrorCode {
    INVALID_LOTTO_NUMBERS("로또 번호는 " + Constants.MIN_LOTTO_NUMBER.getValues() + "부터 "
            + Constants.MAX_LOTTO_NUMBER.getValues() + " 사이의 숫자여야 합니다."),
    INVALID_LOTTO_COUNT(Constants.LOTTO_COUNT.getValues() + "개의 번호를 입력해주세요."),
    INVALID_MONEY(Constants.PRICE_UNIT.getValues() + "원 단위의 금액을 입력해주세요."),
    INPUT_IS_NULL("공백을 입력할 수 없습니다."),
    IS_DUPLICATED("중복된 번호를 입력할 수 없습니다."),
    IS_NOT_NUMBERIC("숫자를 입력해주세요."),
    IS_NOT_NUMBERIC_AND_COMMA("숫자와 콤마를 이용하여 번호를 입력해주세요."),
    INVALID_BONUS("이미 존재하는 번호입니다. 다른 보너스 번호를 입력해주세요.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
