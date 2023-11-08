package lotto.constant;

public enum LottoNumberComposition {
    START_NUMBER(1),
    END_NUMBER(45),
    ENTER_COUNT(6),
    ENTER_BONUS_COUNT(1),
    MIN_PURCHASE_AMOUNT(1000);

    private final int number;
    LottoNumberComposition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
