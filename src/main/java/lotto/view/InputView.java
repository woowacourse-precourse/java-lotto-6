package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.validation.BonusNumberInputValidator;
import lotto.validation.PurchaseAmountValidator;
import lotto.validation.WinningNumbersInputValidator;

public class InputView {
    private static final String PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MSG = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBERS_MSG = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MSG);
        try {
            String input = Console.readLine();
            PurchaseAmountValidator.validateIsPositiveInteger(input);

            int purchaseAmount = Integer.parseInt(input);
            PurchaseAmountValidator.validateIsDivisibleByThousand(purchaseAmount);

            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MSG);
        try {
            String input = Console.readLine();
            WinningNumbersInputValidator.validate(input);
            String[] numbers = input.split(",");
            return convertToWinningNumbers(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private static List<Integer> convertToWinningNumbers(String[] numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(BONUS_NUMBERS_MSG);
        try {
            String input = Console.readLine();
            BonusNumberInputValidator.validate(input, winningNumbers);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }
}
