package util;

public enum LottoValidationValue {
    LOTTO_PRICE(1000);

    private final int value;

    LottoValidationValue(int value) {
        this.value = value;
    }

    public int get(){
        return value;
    }
}
