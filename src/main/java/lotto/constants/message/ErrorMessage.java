package lotto.constants.message;

import lotto.constants.lotto.ViewElement;

public enum ErrorMessage {
    ERROR_TAG("[ERROR] "),
    NOT_NUMERIC_ERROR("숫자 입력이 아닙니다."),
    NOT_THOUSAND_UNIT_ERROR("로또 구입 금액이 %s단위가 아닙니다."),
    LOTTO_NUMBER_SIZE_ERROR("로또의 개수가 %s이 아닙니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 숫자 범위가 %s 부터 %s가 아닙니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 숫자가 중복되어 있습니다."),
    WINNING_NUMBERS_DIVISION_COMMA_ERROR("당첨 번호는 %s(%s)를 기준으로 구분합니다."),
    BONUS_NUMBER_CONTAIN_LOTTO_ERROR("보너스 번호가 당첨 로또 안에 포함되어 있습니다."),
    NUMBER_UPDATE_ERROR("번호를 저장하지 못하였습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TAG.message + message + ViewElement.NEXT_LINE;
    }

    @Override
    public String toString() {
        return message;
    }
}
