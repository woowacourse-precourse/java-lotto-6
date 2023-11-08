package lotto.constant.message;

import lotto.constant.LottoNumber;

public enum ExceptionMessage {
    ERROR("[ERROR] "),
    IS_NOT_ZERO(ERROR.getMessage() + "로또는 0개 이상 구입 가능합니다."),
    IS_NOT_NUMBER(ERROR.getMessage() + "숫자를 입력해주세요"),
    PURCHASE_ERROR(ERROR.getMessage() + "구매 금액은 " + LottoNumber.PURCHASE_AMOUNT_COND.getNumber() + "으로 나누어 떨어져야 합니다."),
    COUNT_ERROR(ERROR.getMessage() + "당첨 번호는 " + LottoNumber.MAX_COUNT.getNumber() + "개를 입력해야 합니다."),
    NUMBER_BLANK(ERROR.getMessage() + "당첨 번호는 ,(쉼표)로 구분하여 입력해야 하며, 공백을 포함할 수 없습니다."),
    NUMBER_DUPLICATE(ERROR.getMessage() + "당첨 번호는 중복될 수 없습니다."),
    NUMBER_RANGE(ERROR.getMessage() + "로또 번호는 " + LottoNumber.FIRST_NUMBER.getNumber() + "부터 "
            + LottoNumber.LAST_NUMBER.getNumber() + " 사이의 숫자여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}