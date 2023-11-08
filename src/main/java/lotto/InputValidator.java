package lotto;

import static lotto.resource.TextResourceProvider.BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45_TEXT;
import static lotto.resource.TextResourceProvider.BONUS_NUMBER_SHOULD_NOT_IN_WINNING_NUMBERS_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS_TEXT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidPurchasedAmountException;
import lotto.exception.InvalidWinningNumbersException;

public class InputValidator {
    public void checkIfNegativeLong(long purchasedAmount) {
        if (purchasedAmount < 0) {
            throw new InvalidPurchasedAmountException(PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT,
                    purchasedAmount);
        }
    }

    public void checkIfDivisibleByLotteryPrice(long purchasedAmount) {
        if (purchasedAmount % 1000 != 0 || purchasedAmount == 0) {
            throw new InvalidPurchasedAmountException(PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT,
                    purchasedAmount);
        }
    }

    public void checkIfNumbersBetween(int startInclusive, int endInclusive, List<Integer> numbers) {
        for (int number : numbers) {
            if (number < startInclusive || number > endInclusive) {
                throw new InvalidWinningNumbersException(WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45_TEXT, numbers);
            }
        }
    }

    public void checkIfNumbersIs6UniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            uniqueNumbers.add(number);
        }
        if (uniqueNumbers.size() != 6 || numbers.size() != 6) {
            throw new InvalidWinningNumbersException(WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS_TEXT, numbers);
        }
    }

    public void checkIfNumberBetween(int startInclusive, int endInclusive, int number) {
        if (number < startInclusive || number > endInclusive) {
            throw new InvalidBonusNumberException(BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45_TEXT, number);
        }
    }

    public void checkIfNumberIsInWinningNumber(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new InvalidBonusNumberException(BONUS_NUMBER_SHOULD_NOT_IN_WINNING_NUMBERS_TEXT, number);
        }
    }

    public void checkIfNumbersSizeIs6(List<Integer> tokens) {
        if (tokens.size() != 6) {
            throw new InvalidWinningNumbersException(
                    WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS_TEXT, tokens);
        }
    }
}
