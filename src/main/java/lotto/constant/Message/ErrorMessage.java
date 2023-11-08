package lotto.constant.Message;

import lotto.constant.Lotto;

public enum ErrorMessage {
    IS_NULL_MESSAGE("[ERROR] 입력값이 없습니다."),
    HAS_BLANK_MESSAGE("[ERROR] 앞 뒤를 제외한 공백이 존재합니다"),
    IS_NOT_DIGIT_MESSAGE("[ERROR] 숫자가 아닙니다."),
    IS_NOT_THOUSAND_UNIT_MESSAGE("[ERROR] " + Lotto.PRICE_PER_LOTTO.getLottoNumber() + "원 단위가 아닙니다."),
    IS_NOT_COMMA_SEPARATOR_MESSAGE("[ERROR] 쉼표로 구분되어 있지 않습니다."),
    IS_NOT_SIX_THINGS_MESSAGE("[ERROR] " + Lotto.NUMBER_OF_REQUIRED_LOTTO_NUMBER.getLottoNumber() + "개를 입력해야합니다."),
    IS_NOT_ONE_THING_MESSAGE("[ERROR] " + Lotto.NUMBER_OF_REQUIRED_BONUS_NUMBER.getLottoNumber() + "개를 입력해야합니다."),
    HAS_DUPLICATE_NUMBER_MESSAGE("[ERROR] 중복값이 존재합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
