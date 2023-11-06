package lotto.constants;

public enum LottoRule {

    STANDARD(1,45,6, 1000);

    private final int startNumber;
    private final int lastNumber;
    private final int lottoSize;
    private final int lottoPrice;

    LottoRule(int startNumber, int lastNumber, int lottoSize, int lottoPrice) {
        this.startNumber = startNumber;
        this.lastNumber = lastNumber;
        this.lottoSize = lottoSize;
        this.lottoPrice = lottoPrice;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public int getLastNumber() {
        return lastNumber;
    }

    public int getLottoSize() {
        return lottoSize;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }
}
