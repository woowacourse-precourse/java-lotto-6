package lotto.controller;

import static lotto.utility.Constants.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public UserInput() {}
    public static Integer PurchaseAmount() {
        String userInput = Console.readLine();
        Integer purchaseAmount = Integer.parseInt(userInput);
        return purchaseAmount;
    }
    public static Integer calculatePurchaseLottoNumber(Integer purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
