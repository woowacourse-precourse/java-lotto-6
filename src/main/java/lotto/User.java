package lotto;

import lotto.utils.Prompt;
import lotto.utils.Error;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    public int inputValidatedPurchaseAmount(LottoManager lottoManager) {
        while (true) {
            int amount = promptForPurchaseAmount();
            if (lottoManager.verifyPurchaseAmount(amount)) {
                return amount;
            }
            System.out.println(Error.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private int promptForPurchaseAmount() {
        System.out.println(Prompt.INPUT_PURCHASE_AMOUNT.getMessage());
        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(Error.INVALID_PURCHASE_AMOUNT.getMessage());
            return 0; // Indicates invalid input
        }
    }

    public List<Integer> inputValidatedWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = promptForWinningNumbers();
                new Lotto(winningNumbers); // Lotto constructor validates numbers
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> promptForWinningNumbers() {
        System.out.println(Prompt.INPUT_WINNING_NUMBERS.getMessage());
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public WinningNumber inputValidatedBonusNumber(Lotto lotto) {
        while (true) {
            int bonusNumber = promptForBonusNumber();
            try {
                return new WinningNumber(lotto, bonusNumber); // WinningNumber constructor validates number
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int promptForBonusNumber() {
        System.out.println(Prompt.INPUT_BONUS_NUMBER.getMessage());
        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(Error.INVALID_BONUS_NUMBER.getMessage());
            return 0; // Indicates invalid input
        }
    }
}
