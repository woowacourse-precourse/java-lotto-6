package lotto.controller;

import static lotto.utility.Constants.COMMA;
import static lotto.utility.Constants.ERROR_MESSAGE_1;
import static lotto.utility.Constants.ERROR_MESSAGE_2;
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
    public static Integer PurchaseAmount() throws IllegalArgumentException {
        while (true) {
            try {
                String userInput = Console.readLine();
                UserException.validateAll(userInput);
                Integer purchaseAmount = Integer.parseInt(userInput);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Integer calculatePurchaseLottoNumber(Integer purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static void winningNumbers() throws IllegalArgumentException {
        String userInput;
        List<Integer> winningNumbers = null;
        while (true) {
            try {
                userInput = Console.readLine();
                winningNumbers = Arrays.stream(userInput.split(COMMA))
                        .map(String::trim) // 공백 제거
                        .map(Integer::parseInt) // 정수 변환
                        .collect(Collectors.toList());
                LottoException.validateLottoAll(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        User.setWinningNumbers(winningNumbers);
    }

    public static void bonusNumber() throws IllegalArgumentException {
        while (true) {
            try {
                String userInput = Console.readLine();
                LottoException.validateBonusAll(userInput);
                Integer bonusNumber = Integer.parseInt(userInput);
                User.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
