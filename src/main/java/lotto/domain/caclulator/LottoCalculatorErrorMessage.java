package lotto.domain.caclulator;

import lotto.domain.LottoConfig;

public enum LottoCalculatorErrorMessage {

    INVALID_LOTTO_PRICE("로또 가격은 양수여야 합니다."),
    NOT_DIVISIBLE_AMOUNT("금액은 로또 가격 단위로 나누어 떨어져야 합니다.");

    private final String message;

    LottoCalculatorErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}

