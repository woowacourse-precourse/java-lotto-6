package lotto.controller;

import static lotto.utility.Constants.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public User() {}
    public Integer inputPurchaseAmount() {
        String userInput = Console.readLine();
        Integer purchaseAmount = Integer.parseInt(userInput);
        return purchaseAmount;
    }
    public Integer calculatePurchaseLottoNumber(Integer purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
