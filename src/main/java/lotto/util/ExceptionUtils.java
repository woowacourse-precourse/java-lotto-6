package lotto.util;

public enum ExceptionUtils {
    NOT_INTEGER_ERROR("[ERROR] 숫자가 아닌 값이 입력되었습니다."),
    LOTTO_UNIT_ERROR("[ERROR] 1,000원 단위로만 구매할 수 있습니다."),
    LOTTO_SIZE_ERROR("[ERROR] 당첨 번호는 6개로 입력해야합니다."),
    LOTTO_DUP_ERROR("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    LOTTO_RANGE_ERROR("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_MIN_PRICE_ERROR("[ERROR] 최소 구입 금액은 1,000원입니다.");


    private final String ErrorMessage;

    ExceptionUtils(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }
}
