package lotto.config;

import static lotto.config.LottoConfig.PURCHASE_AMOUNT_MAX;
import static lotto.config.LottoConfig.PURCHASE_DIVISIBLE_AMOUNT;

public enum PurchaseErrorMessage {
    PURCHASE_BLANK_ERROR_MESSAGE("[ERROR] 로또 구입 금액이 없거나 공백만 입력했습니다."),
    PURCHASE_NUMERIC_ERROR_MESSAGE("[ERROR] 로또 구입 금액은 자연수만 입력해야 합니다."),
    PURCHASE_STARTS_ZERO_ERROR_MESSAGE("[ERROR] 첫 문자가 0이 아니어야 합니다."),
    PURCHASE_DIVISIBLE_ERROR_MESSAGE(String.format("[ERROR] 로또 구입 금액은 %s원 단위로 입력해야 합니다.",
            PURCHASE_DIVISIBLE_AMOUNT.getValue())),
    PURCHASE_AMOUNT_MAX_ERROR_MESSAGE(String.format(
            "[ERROR] 로또 구입 금액은 복권 및 복권 기금법 제5조 2항, 시행령 제3조에 따라 최대 %s원 까지만 구매 가능합니다.",
            PURCHASE_AMOUNT_MAX.getValue()));

    private final String message;

    PurchaseErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
