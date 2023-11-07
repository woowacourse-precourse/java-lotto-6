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

    public static Integer inputPurchaseAmount() {
        String inputValue = null;
        Boolean flag = false;
        while(!flag) {
            System.out.println(MessageConstants.PURCHASE_AMOUNT_GUIDE);
            inputValue = Console.readLine();
            try {
                PurchaseAmountValidator.validateType(inputValue);
                PurchaseAmountValidator.validateUnit(inputValue);
                flag = true;
            } catch (Exception e) {}
        }
        return Integer.parseInt(inputValue);
    }

    public static List<Integer> inputWinningNumbers() {
        String[] inputValues = null;
        Boolean flag = false;
        while (!flag) {
            System.out.println(MessageConstants.WINNING_NUMBERS_GUIDE);
            inputValues = Console.readLine().split(",");
            try {
                WinningNumbersValidator.validateLength(inputValues); // 개수
                WinningNumbersValidator.validateType(inputValues); // 숫자
                WinningNumbersValidator.validateRange(inputValues); // 범위
                WinningNumbersValidator.validateDuplicate(inputValues); // 중복
                flag = true;
            } catch (IllegalArgumentException e) {}
        }

        return parseStringToInteger(inputValues);
    }

    private static List<Integer> parseStringToInteger(String[] inputValues) {
        List<Integer> inputIntValues = Arrays.stream(inputValues).map(v -> Integer.parseInt(v)).collect(Collectors.toList());
        return inputIntValues;
    }

    public static Integer inputBonusNumber() {
        String inputValue = null;
        Boolean flag = false;

        while (!flag) {
            System.out.println(MessageConstants.BONUS_NUMBER_GUIDE);
            inputValue = Console.readLine();

            try {
                BonusNumberValidator.validateType(inputValue);
                BonusNumberValidator.validateRange(inputValue);
                flag = true;
            } catch (IllegalArgumentException e) {}
        }
        return Integer.parseInt(inputValue);
    }
}
