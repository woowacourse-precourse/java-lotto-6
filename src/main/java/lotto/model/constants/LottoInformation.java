package lotto.model.constants;

public enum LottoInformation {
    COUNT_DIVISION(1000),
    BUY_PRICE(0);
    private int value;

    LottoInformation(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
