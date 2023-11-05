package lotto.controller;

import lotto.GameConstants;

public class PurchaseAmountConverter implements Converter<Integer> {
    @Override
    public Integer convert(String purchaseAmount) {
        int numericPurchaseAmount = Integer.parseInt(purchaseAmount);
        return numericPurchaseAmount / GameConstants.UNIT_PURCHASE_PRICE;
    }
}