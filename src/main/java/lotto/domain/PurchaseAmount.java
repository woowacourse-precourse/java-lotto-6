package lotto.domain;

import lotto.constant.ExceptionConstant;
import lotto.constant.NumberConstant;

public class PurchaseAmount {

    private final int totalPrice;

    private PurchaseAmount(String price) {
        int totalPrice = convertStrtoInt(price);
        validateTotalPrice(totalPrice);
        this.totalPrice = totalPrice;
    }

    public static PurchaseAmount from(String price) {
        return new PurchaseAmount(price);
    }

    private void validateTotalPrice(int totalPrice) {
        validateMinimumPrice(totalPrice);
        validateMultiplesOfThousand(totalPrice);
    }

    private int convertStrtoInt(String userInput) {
        return Integer.parseInt(userInput);
    }

    private void validateMinimumPrice(int totalPrice) {
        if (totalPrice < NumberConstant.LOTTO_PRICE.getNumber()) {
            throw new IllegalArgumentException(ExceptionConstant.PURCHASE_MIN_NUMBER.getMessage());
        }
    }

    private void validateMultiplesOfThousand(int totalPrice) {
        if (totalPrice % NumberConstant.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ExceptionConstant.PURCHASE_REMAINDER.getMessage());
        }
    }

    public int calculateAmountOfLotteries() {
        return totalPrice / NumberConstant.LOTTO_PRICE.getNumber();
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
