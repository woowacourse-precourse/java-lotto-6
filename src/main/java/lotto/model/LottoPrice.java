package lotto.model;

public enum LottoPrice {
    PRICE(1000),
    ;

    private final int value;

    LottoPrice(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
