package lotto.domain.cash;

enum CashExceptionMessages {

    INVALID_CASH_UNIT(String.format(
            "구매 금액은 %d원 단위로 입력해주세요.",
            CashConfig.CASH_UNIT.getValue()
    )),

    NEGATIVE_OR_ZERO(
            "구매 금액은 양수이어야 합니다."
    );

    private final String message;

    CashExceptionMessages(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }

}
