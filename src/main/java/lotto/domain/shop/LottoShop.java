package lotto.domain.shop;

public class LottoShop {

    private final int LOTTO_PRICE = ShopConfig.LOTTO_PRICE.getValue();

    public int countPurchasableAmount(int cash) {
        validateMaxPurchaseLimit(cash);
        return cash / LOTTO_PRICE;
    }

    private void validateMaxPurchaseLimit(int cash) {
        if (cash > ShopConfig.LOTTO_PURCHASE_LIMIT.getValue()) {
            throw new IllegalArgumentException(ShopExceptionMessages.LOTTO_PURCHASE_OVER_LIMIT.getMessage());
        }
    }

}
