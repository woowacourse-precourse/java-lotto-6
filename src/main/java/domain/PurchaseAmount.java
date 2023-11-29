package domain;

import util.constants.Constants;

import static util.message.ExceptionMessage.UNIT_MESSAGE;

public class PurchaseAmount {
    private final int amount;
    private final int quantity;

    private PurchaseAmount(final int purchaseAmount) {
        validateDivisibleBy1000(purchaseAmount);
        this.amount = purchaseAmount;
        this.quantity = calculatequantity();
    }

    public static PurchaseAmount create(final int purchaseAmount){
        return new PurchaseAmount(purchaseAmount);
    }

    public int getQuantity(){
        return quantity;
    }

    private int calculatequantity(){
        return amount / Constants.ONE_THOUSAND.getValue();
    }

    private static int validateDivisibleBy1000(final int amount){
        if(amount % Constants.ONE_THOUSAND.getValue() != Constants.ZERO.getValue()){
            throw new IllegalArgumentException(String.format(UNIT_MESSAGE.getValue(), Constants.ONE_THOUSAND.getValue()));
        }
        return amount;
    }
}
