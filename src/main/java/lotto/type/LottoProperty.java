package lotto.type;

public enum LottoProperty {
    LOTTO_NUMBER_SIZE(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_PRICE(1000);

    private final int lottoProperty;

    LottoProperty(int lottoProperty) { this.lottoProperty = lottoProperty; }

    public int getLottoProperty() { return lottoProperty; }
}
