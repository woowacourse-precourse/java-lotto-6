package lotto.view;

import lotto.domain.Money;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR]"),
    INVALID_LOTTO_NUMS_COUNT("[ERROR] %d개의 숫자를 입력해주세요.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getInvalidPurchaseAmountMessage() {
        return INVALID_PURCHASE_AMOUNT.getMessage();
    }

    public String getInvalidLottoNumsCountMessage(Integer lottoNumsCount) {
        return String.format(INVALID_LOTTO_NUMS_COUNT.getMessage(), lottoNumsCount);
    }
}
