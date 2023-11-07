package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constants.InputMessage;
import lotto.model.Bonus;
import lotto.model.InputValidation;
import lotto.model.Lotto;
import lotto.model.Purchase;

public class InputView {
    public static int getPurchaseAmount() {
        while (true) {
            try {
                String input = inputPurchaseAmount();
                return validateAllPurchase(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println();
        while (true) {
            try {
                String[] numbers = inputWinningNumbers();
                return validateAllWinningNumbers(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println();
        while (true) {
            try {
                String input = inputBonusNumber();
                return validateAllBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT.getMessage());
        String input = Console.readLine();
        return input;
    }

    private static int validateAllPurchase(String input) {
        int purchaseAmount = InputValidation.validatePurchaseAmount(input);
        Purchase purchase = new Purchase(purchaseAmount);
        return purchase.getPurchase();
    }

    private static String[] inputWinningNumbers() {
        System.out.println(InputMessage.LOTTO_NUMBERS.getMessage());
        String[] numbers = Console.readLine().split(",");
        return numbers;
    }

    private static List<Integer> validateAllWinningNumbers(String[] numbers) {
        List<Integer> winningNumbers = InputValidation.validateWinningNumbers(numbers);
        Lotto lotto = new Lotto(winningNumbers);
        return lotto.getLotto();
    }

    private static String inputBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        return input;
    }

    private static int validateAllBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = InputValidation.validateBonusNumber(input);
        Bonus bonus = new Bonus(bonusNumber, winningNumbers);
        return bonus.getBonus();
    }
}
