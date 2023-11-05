package lotto.domain;

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
        int priceAmount = Integer.parseInt(userInput);
        return priceAmount / NumberConstant.LOTTO_PRICE.getNumber();
    }
}
