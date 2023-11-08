package lotto.controller;

import static lotto.utility.Constants.COMMA;
import static lotto.utility.Constants.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoException;
import lotto.exception.UserException;
import lotto.model.User;

public class UserInput {
    public UserInput() {}
    public static Integer PurchaseAmount() {
        String userInput = Console.readLine();
        UserException.validatePurchaseAmountOnlyInt(userInput);
        Integer purchaseAmount = Integer.parseInt(userInput);
        return purchaseAmount;
    }

    public static Integer calculatePurchaseLottoNumber(Integer purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static void winningNumbers() {
        String userInput = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(userInput.split(COMMA))
                                                .map(Integer::parseInt)
                                                .collect(Collectors.toList());
        LottoException.validateLottoAll(winningNumbers);
        User.setWinningNumbers(winningNumbers);
    }

    public static void bonusNumber() {
        String userInput = Console.readLine();
        Integer bonusNumber = Integer.parseInt(userInput);
        User.setBonusNumber(bonusNumber);
    }
}
