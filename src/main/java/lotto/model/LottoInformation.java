package lotto.model;

public enum LottoInformation {
    COUNT_DIVISION(1000);

    private int value;

    LottoInformation(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
