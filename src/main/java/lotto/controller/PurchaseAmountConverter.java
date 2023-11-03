package lotto.controller;

import lotto.MagicNumber;

public class PurchaseAmountConverter implements Converter<Integer> {
    @Override
    public Integer convert(String purchaseAmount) {
        int numericPurchaseAmount = Integer.parseInt(purchaseAmount);
        return numericPurchaseAmount % MagicNumber.UNIT_PURCHASE_PRICE;
    }
}
