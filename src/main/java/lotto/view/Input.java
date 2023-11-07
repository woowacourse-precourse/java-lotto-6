package lotto.view;

import static lotto.message.ErrorMessage.BONUS_NUMBER_RANGE;
import static lotto.message.ErrorMessage.DIVISIBLE_BY_1000;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_BONUS_NUMBER;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_MONEY;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_WINNING_NUMBERS;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_DUPLICATE;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_LENGTH;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_RANGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {
    public int getValidPurchaseAmount() {
        int purchaseAmount;

        while (true) {
            Output.printPurchaseAmountMessage();
            try {
                purchaseAmount = getPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                checkPurchaseAmountExceptionCategory(e);
            }
        }

        return purchaseAmount;
    }

    private int getPurchaseAmount() {
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine());
            validationPurchaseAmountInThousands(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_MONEY.errorMessage());
        }
    }

    private void checkPurchaseAmountExceptionCategory(IllegalArgumentException e) {
        if (e.getMessage().equals(NUMBER_FORMAT_MONEY.errorMessage())) {
            System.out.println(NUMBER_FORMAT_MONEY.errorMessage());
        }

        if (e.getMessage().equals(DIVISIBLE_BY_1000.errorMessage())) {
            System.out.println(DIVISIBLE_BY_1000.errorMessage());
        }
    }

    public List<Integer> getValidWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            Output.printWinningNumberMessage();
            try {
                winningNumbers = getWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                checkWinningNumbersExceptionCategory(e);
            }
        }
        return winningNumbers;
    }

    private List<Integer> getWinningNumbers() {
        try {
            String inputNumbers = Console.readLine();
            List<Integer> winningNumbers = Arrays.stream(inputNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            validationWinningNumbersLength(winningNumbers);
            validationWinningNumbersRange(winningNumbers);
            validationWinningNumbersDuplicate(winningNumbers);

            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_WINNING_NUMBERS.errorMessage());
        }
    }

    private static void checkWinningNumbersExceptionCategory(IllegalArgumentException e) {
        if (e.getMessage().equals(WINNING_NUMBERS_LENGTH.errorMessage())) {
            System.out.println(WINNING_NUMBERS_LENGTH.errorMessage());
        }

        if (e.getMessage().equals(WINNING_NUMBERS_RANGE.errorMessage())) {
            System.out.println(WINNING_NUMBERS_RANGE.errorMessage());
        }

        if (e.getMessage().equals(NUMBER_FORMAT_WINNING_NUMBERS.errorMessage())) {
            System.out.println(NUMBER_FORMAT_WINNING_NUMBERS.errorMessage());
        }

        if (e.getMessage().equals(WINNING_NUMBERS_DUPLICATE.errorMessage())) {
            System.out.println(WINNING_NUMBERS_DUPLICATE.errorMessage());
        }
    }

    public int getValidBonusNumber() {
        int bonusNumber;
        while (true) {
            Output.printBonusNumberMessage();
            try {
                bonusNumber = getBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                checkBonusNumberExceptionCategory(e);
            }
        }
        return bonusNumber;
    }

    private int getBonusNumber() {
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            validationBonusNumberRange(bonusNumber);

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_BONUS_NUMBER.errorMessage());
        }
    }

    private static void checkBonusNumberExceptionCategory(IllegalArgumentException e) {
        if (e.getMessage().equals(BONUS_NUMBER_RANGE.errorMessage())) {
            System.out.println(BONUS_NUMBER_RANGE.errorMessage());
        }

        if (e.getMessage().equals(NUMBER_FORMAT_BONUS_NUMBER.errorMessage())) {
            System.out.println(NUMBER_FORMAT_BONUS_NUMBER.errorMessage());
        }
    }

    private void validationPurchaseAmountInThousands(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(DIVISIBLE_BY_1000.errorMessage());
        }
    }

    private void validationWinningNumbersLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_LENGTH.errorMessage());
        }
    }

    private void validationWinningNumbersRange(List<Integer> winningNumbers) {
        winningNumbers.stream().filter(number -> !(1 <= number && number <= 45))
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(WINNING_NUMBERS_RANGE.errorMessage());
                });
    }

    private void validationWinningNumbersDuplicate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE.errorMessage());
        }
    }

    private void validationBonusNumberRange(int bonusNumber) {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE.errorMessage());
        }
    }
}
