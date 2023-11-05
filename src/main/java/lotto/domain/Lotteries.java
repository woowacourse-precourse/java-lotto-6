package lotto.domain;

import lotto.constant.ExceptionConstant;
import lotto.constant.NumberConstant;

public class Lotteries {

    private int Lotteries;

    private Lotteries(String userInput) {
        this.Lotteries = generateLotteries(userInput);
    }

    public static Lotteries from(String userInput) {
        return new Lotteries(userInput);
    }

    private int generateLotteries(String userInput) {
        int totalPrice = Integer.parseInt(userInput);
        validateMultiplesOfThousand(totalPrice);
        validateMinimumPrice(totalPrice);
        return totalPrice / NumberConstant.LOTTO_PRICE.getNumber();
    }

    private void validateMultiplesOfThousand(int totalPrice) {
        if (totalPrice / NumberConstant.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ExceptionConstant.PURCHASE_REMAINDER.getMessage());
        }
    }

    private void validateMinimumPrice(int totalPrice) {
        if (totalPrice < NumberConstant.LOTTO_PRICE.getNumber()) {
            throw new IllegalArgumentException(ExceptionConstant.PURCHASE_MIN_NUMBER.getMessage());
        }
    }
}
