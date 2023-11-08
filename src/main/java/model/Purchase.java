package model;

import static model.ErrorMessage.*;
public class Purchase {
    private final int MODULAR_NUMBER = 0;
    private final int LOTTO_PRICE = 1000;
    private int purchaseCount;
    private int purchasePrice;

    public void Number(int price) {
        priceCheck(price);
        purchasePrice = price;
        purchaseCount = price / LOTTO_PRICE;

    }

    private void priceCheck(int price) {
        if (price % LOTTO_PRICE != MODULAR_NUMBER) {
            throw new IllegalArgumentException(WRONG_ORDER_PRICE.getMessage());
        }
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }


}
