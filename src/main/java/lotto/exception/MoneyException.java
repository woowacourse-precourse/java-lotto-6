package lotto.exception;

import lotto.config.GameConfig;

public enum MoneyException implements CustomException {

    INVALID_RANGE(String.format("구입 금액은 최소 %d원 이상으로 입력해주세요.", GameConfig.MONET_MIN_NUMBER)),
    INVALID_UNIT(String.format("구입 금액은 %d원 단위로 입력해주세요.", GameConfig.LOTTO_PRICE_UNIT));

    private final String message;

    MoneyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
