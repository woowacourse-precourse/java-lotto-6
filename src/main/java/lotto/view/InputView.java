package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.validator.Validator;

public class InputView {
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return checkPurchaseAmount();
    }

    private int checkPurchaseAmount() {
        String purchaseAmount = Console.readLine().trim();
        try {
            Validator.validatePurchaseAmount(purchaseAmount);
            return Integer.parseInt(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkPurchaseAmount();
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return checkWinningNumbers();
    }

    private List<Integer> checkWinningNumbers() {
        String winningNumbersInput = Console.readLine().trim();
        try {
            Validator.validateWinningNumbers(winningNumbersInput);
            return changeInputToNumber(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkWinningNumbers();
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(INPUT_BONUS_NUMBER);
        return checkBonusNumber(winningNumbers);
    }

    private int checkBonusNumber(List<Integer> winningNumbers) {
        String bonusNumberInput = Console.readLine().trim();
        try {
            Validator.validateBonusNumber(winningNumbers, bonusNumberInput);
            return Integer.parseInt(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkBonusNumber(winningNumbers);
        }
    }

    private List<Integer> changeInputToNumber (String input) {
        String[] values = input.split(",");
        List<Integer> winningNumbers =  new ArrayList<>();
        for (String value: values) {
            int number = Integer.parseInt(value);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

}
