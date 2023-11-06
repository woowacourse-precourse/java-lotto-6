package lotto.domain.cash;

enum CashConfig {

    CASH_UNIT("구매 금액 단위", 1000);

    private final String description;
    private final int value;

    CashConfig(String description, int value) {
        this.description = description;
        this.value = value;
    }

    int getValue() {
        return value;
    }

}
