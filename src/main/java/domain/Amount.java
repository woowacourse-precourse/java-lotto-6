package domain;

import Constants.PurchaseAmountConstant;

import static util.message.ExceptionMessage.*;
import static util.message.ExceptionMessage.UNIT_MESSAGE;

public class Amount {
    private final int amount;

    private Amount(final String purchaseAmount){
        validateBlank(purchaseAmount);
        int purchase = validateType(purchaseAmount);
        purchase = validateRange(purchase);
        amount = validateDivisibleBy1000(purchase);
    }

    public static Amount create(final String purchaseAmount){
        return new Amount(purchaseAmount);
    }

    private void validateBlank(final String purchaseAmount){
        if (purchaseAmount == null || purchaseAmount.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "구입금액"));
        }
    }

    private int validateType(final String purchaseAmount) {
        int count;
        try {
            count = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException((String.format(TYPE_MESSAGE.getValue(), "구입금액")));
        }
        return count;
    }

    private int validateRange(final int purchaseAmount) {
        if (purchaseAmount <= PurchaseAmountConstant.ZERO.getValue()) {
            throw new IllegalArgumentException(String.format(RANGE_MESSAGE.getValue(), PurchaseAmountConstant.ZERO.getValue()));
        }
        return purchaseAmount;
    }

    private int validateDivisibleBy1000(final int amount){
        if(amount % PurchaseAmountConstant.ONE_THOUSAND.getValue() != PurchaseAmountConstant.ZERO.getValue()){
            throw new IllegalArgumentException(String.format(UNIT_MESSAGE.getValue(), PurchaseAmountConstant.ONE_THOUSAND.getValue()));
        }
        return amount;
    }
}
