package lotto.exception;

import lotto.constant.LottoConstant;

public enum ErrorMessage {
    INPUT_IS_EMPTY("입력값은 비어있을 수 없습니다."),
    INPUT_NOT_A_NUMBER("입력값은 숫자여야 합니다."),
    INPUT_NOT_POSITIVE_NUMBER("입력값은 자연수여야 합니다."),

    WRONG_LOTTO_NUMBERS_COUNT(String.format("로또 번호는 %d개여야 합니다.", LottoConstant.LOTTO_NUMBERS_COUNT)),
    LOTTO_NUMBERS_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE(String.format("로또 번호는 %d이상 %d이하의 숫자여야 합니다.", LottoConstant.LOTTO_NUMBER_MIN,
            LottoConstant.LOTTO_NUMBER_MAX)),
    INVALID_PURCHASE_AMOUNT(String.format("로또 구입 금액은 %d원 단위여야 합니다.", LottoConstant.LOTTO_PRICE));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
