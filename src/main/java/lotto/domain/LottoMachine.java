package lotto.domain;

public class LottoMachine {
    private static final int defaultSalePrice = 1_000;
    private int lottoCount;

    public LottoMachine(int price) {
        validateUnitOfMoney(price);
        lottoCount = calculatePurchaseCount(price);
    }

    private void validateUnitOfMoney(int price) {
        if (price % defaultSalePrice != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
        }
    }

    private int calculatePurchaseCount(int price) {
        return price / defaultSalePrice;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getPurchasePrice() {
        return lottoCount * defaultSalePrice;
    }
}
