package lotto.view;

public enum Amount {
    AMOUNT_1(5000),
    AMOUNT_2(50000),
    AMOUNT_3(1500000),
    AMOUNT_4(30000000),
    AMOUNT_5(2000000000);

    private final int amountValue;

    Amount(int amountValue) {
        this.amountValue = amountValue;
    }

}