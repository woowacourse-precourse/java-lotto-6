package lotto.util;

import static lotto.domain.PurchasePrice.MINIMUM_UNIT_PRICE;

public enum ExceptionMessage {
    NOT_NUMERIC("입력값을 다시 확인해주세요."),
    CHECK_UNIT_PRICE(String.format("%s원 단위로 입력해주세요.", MINIMUM_UNIT_PRICE));

    private static final String ERROR = "[ERROR] %s";
    private final String message;

    ExceptionMessage(final String errorMessage) {
        this.message = String.format(ERROR, errorMessage);
    }

    public String getMessage() {
        return message;
    }
}
