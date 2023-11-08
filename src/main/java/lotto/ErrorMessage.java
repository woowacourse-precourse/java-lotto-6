package lotto;

import lotto.constants.LottoConfig;

public enum ErrorMessage {
    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호 범위가 아닙니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    DIFFERENT_LOTTO_SIZE("[ERROR] 로또 번호크기가 다릅니다."),
    ZERO_PAID_AMOUNT("[ERROR] 0원보다 큰 금액을 입력해주세요."),
    NOT_DIVISIBLE_PAID_AMOUNT("[ERROR] 로또 금액으로 나누어떨어지지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}