package lotto.view;

import lotto.utils.LottoParser;

public enum ExceptionMessage {

    CONTAINED_EXCEPTION("보너스 번호가 당첨 번호에 포함되어 있습니다"),
    NOT_INTEGER_EXCEPTION("숫지와 구분자, '" + LottoParser.NUMBER_SEPARATOR + "' 만 입력할 수 있습니다."),
    INPUT_BLANK_EXCEPTION("입력 값이 공백입니다."),
    DUPLICATE_EXCEPTION("로또는 중복된 숫자를 가질 수 없습니다"),
    LOTTO_RANGE_EXCEPTION("로또 범위를 벗어나는 숫자를 가질 수 없습니다"),
    LOTTO_PRICE_UNITS_EXCEPTION("입력 값이 로또 구매 단위여야 합니다."),
    LOTTO_SIZE_EXCEPTION("로또는 6개의 숫자를 가져야 합니다"),
    PURCHASE_NOT_AVAILABLE_EXCEPTION("입력 값이 최소 한 장의 로또 구매 단위보다 커야 합니다.");

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
