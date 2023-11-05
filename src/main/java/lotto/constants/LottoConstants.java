package lotto.constants;

public enum LottoConstants {

    MIN_NUMBER(1), MAX_NUMBER(45), LENGTH(6), PRICE(1000);

    private int constants;

    private LottoConstants(int number) {
        this.constants = number;
    }

    public int getConstants() {
        return constants;
    }
}
