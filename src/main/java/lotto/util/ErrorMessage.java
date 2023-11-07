package lotto.util;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    ERROR_INPUT_PRICE_MESSAGE(LottoValues.LOTTO_PRICE+"원 단위 숫자로 입력해야 합니다."),
    ERROR_INPUT_WINNING_NUMBER_MESSAGE(LottoValues.MIN_LOTTO_NUMBER+"부터"+LottoValues.MAX_LOTTO_NUMBER+"사이 값을 '"
            +LottoValues.INPUT_SPLIT_PARAMETER+"'로 구분지어 입력해야 합니다."),
    ERROR_INPUT_BONUS_NUMBER_MESSAGE(LottoValues.MIN_LOTTO_NUMBER+"부터"+LottoValues.MAX_LOTTO_NUMBER+"사이 값을 입력해야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ErrorMessage.ERROR_PREFIX+message;
    }
}
