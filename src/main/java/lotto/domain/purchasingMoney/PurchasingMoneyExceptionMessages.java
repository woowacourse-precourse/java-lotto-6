package lotto.domain.purchasingMoney;

enum PurchasingMoneyExceptionMessages {

    INVALID_CASH_UNIT(String.format(
            "구매 금액은 %d원 단위로 입력해주세요.",
            PurchasingMoneyConfig.CASH_UNIT.getValue()
    )),

    NEGATIVE_OR_ZERO(
            "구매 금액은 양수이어야 합니다."
    ),

    LOTTO_PURCHASE_OVER_LIMIT(String.format(
            "로또 구매액 한도는 %d원입니다.",
            PurchasingMoneyConfig.LOTTO_PURCHASE_LIMIT.getValue()
    ));

    private final String message;

    PurchasingMoneyExceptionMessages(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }

}
