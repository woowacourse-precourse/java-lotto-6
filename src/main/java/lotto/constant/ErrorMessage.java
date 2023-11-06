package lotto.constant;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

public enum ErrorMessage {
    NULL_EXCEPTION("빈 값을 입력하셨습니다. 다시 입력해주세요."),
    DIGIT_EXCEPTION("잘못된 입력입니다. 숫자를 입력해주세요."),
    MULTIPLE_EXCEPTION(LOTTO_PRICE + "원 단위로 입력해주세요."),
    SIZE_EXCEPTION("쉼표(,)를 기준으로 구분하여 6개의 숫자를 입력해주세요."),
    NUMBER_IN_RANGE_EXCEPTION("1부터 45 사이의 숫자를 입력해주세요."),
    DUPLICATION_EXCEPTION("중복되지 않는 숫자를 입력해주세요."),
    LOTTO_NUMBER_SIZE_EXCEPTION("6자리 숫자를 입력해주세요.");

    private final String ERROR_PREFIX = "[ERROR]";
    private String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("%s %s", ERROR_PREFIX, message);
    }
}
