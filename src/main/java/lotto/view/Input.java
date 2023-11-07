package lotto.view;

import static lotto.message.ErrorMessage.BONUS_NUMBER_RANGE;
import static lotto.message.ErrorMessage.DIVISIBLE_BY_1000;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_BONUS_NUMBER;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_MONEY;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_WINNING_NUMBERS;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_LENGTH;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_RANGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {
    public int getPurchaseAmount() {
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine());
            validationPurchaseAmountInThousands(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_MONEY.errorMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        try {
            String inputNumbers = Console.readLine();
            List<Integer> winningNumbers = Arrays.stream(inputNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            validationWinningNumbersLength(winningNumbers);
            validationWinningNumbersRange(winningNumbers);

            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_WINNING_NUMBERS.errorMessage());
        }
    }

    public int getBonusNumber() {
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            validationBonusNumberRange(bonusNumber);

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_BONUS_NUMBER.errorMessage());
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

    private void validationBonusNumberRange(int bonusNumber) {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE.errorMessage());
        }
    }
}
