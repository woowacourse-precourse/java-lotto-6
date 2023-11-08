package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validators.BonusNumberValidator;
import lotto.constants.MessageConstants;
import lotto.validators.PurchaseAmountValidator;
import lotto.validators.WinningNumbersValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static List<String> winningNumbers;

    public static Integer inputPurchaseAmount() {
        String purchaseAmount = null;
        Boolean flag = false;

        while(!flag) {
            System.out.println(MessageConstants.PURCHASE_AMOUNT_GUIDE);
            purchaseAmount = Console.readLine();
            try {
                PurchaseAmountValidator.validateType(purchaseAmount);
                PurchaseAmountValidator.validateUnit(purchaseAmount);
                flag = true;
            } catch (IllegalArgumentException e) {}
        }
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputWinningNumbers() {
        winningNumbers = null;
        Boolean flag = false;

        while (!flag) {
            System.out.println(MessageConstants.WINNING_NUMBERS_GUIDE);
            winningNumbers = Arrays.stream(Console.readLine().split(",")).toList();
            try {
                WinningNumbersValidator.validateLength(winningNumbers);
                WinningNumbersValidator.validateType(winningNumbers);
                WinningNumbersValidator.validateRange(winningNumbers);
                WinningNumbersValidator.validateDuplicate(winningNumbers);
                flag = true;
            } catch (IllegalArgumentException e) {}
        }

        return parseStringToInteger(winningNumbers);
    }

    private static List<Integer> parseStringToInteger(List<String> winningNumbers) {
        List<Integer> winningIntNumbers = winningNumbers.stream().map(v -> Integer.parseInt(v)).collect(Collectors.toList());
        return winningIntNumbers;
    }

    public static Integer inputBonusNumber() {
        String bonusNumber = null;
        Boolean flag = false;

        while (!flag) {
            System.out.println(MessageConstants.BONUS_NUMBER_GUIDE);
            bonusNumber = Console.readLine();
            try {
                BonusNumberValidator.validateType(bonusNumber);
                BonusNumberValidator.validateRange(bonusNumber);
                BonusNumberValidator.validateDuplicate(bonusNumber, winningNumbers);
                flag = true;
            } catch (IllegalArgumentException e) {}
        }
        return Integer.parseInt(bonusNumber);
    }
}
