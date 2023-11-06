package lotto;

import static java.util.stream.Collectors.toList;
import static lotto.resource.TextResourceProvider.BONUS_NUMBER_CANNOT_CONVERT_TO_INTEGER_TEXT;
import static lotto.resource.TextResourceProvider.BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45_TEXT;
import static lotto.resource.TextResourceProvider.BONUS_NUMBER_SHOULD_NOT_IN_WINNING_NUMBERS_TEXT;
import static lotto.resource.TextResourceProvider.ERROR_TEXT_FORMAT;
import static lotto.resource.TextResourceProvider.INPUT_BONUS_NUMBER_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_DELIMITER;
import static lotto.resource.TextResourceProvider.INPUT_PURCHASE_AMOUNT_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_WINNING_NUMBERS_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS_TEXT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidPurchasedAmountException;
import lotto.exception.InvalidWinningNumbersException;

public class InputInterface {

    public long getPurchasedAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_TEXT);

        return getValidPurchasedAmount();
    }

    public List<Integer> getWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_TEXT);
        return getValidWinningNumbers();
    }

    public int getBonusNumber(List<Integer> numbers) {
        System.out.println(INPUT_BONUS_NUMBER_TEXT);
        return getValidBonusNumber(numbers);
    }

    private long getValidPurchasedAmount() {
        try {
            String input = Console.readLine();
            long purchaseAmount = convertToPurchasedAmount(input);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_TEXT_FORMAT.format(e.getMessage()));
            return getPurchasedAmount();
        }
    }

    private static long convertToPurchasedAmount(String input) {
        try {
            long purchasedAmount = Long.parseLong(input);
            checkIfNegativeLong(purchasedAmount);
            checkIfDivisibleByLotteryPrice(purchasedAmount);
            return purchasedAmount;
        } catch (NumberFormatException e) {
            throw new InvalidPurchasedAmountException(PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT,
                    input, e);
        }
    }

    private List<Integer> getValidWinningNumbers() {
        try {
            String input = Console.readLine();
            return convertToWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_TEXT_FORMAT.format(e.getMessage()));
            return getValidWinningNumbers();
        }
    }

    private static List<Integer> convertToWinningNumbers(String input) {
        try {
            List<Integer> tokens = Arrays.stream(input.split(INPUT_DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());
            if (tokens.size() != 6) {
                throw new InvalidWinningNumbersException(
                        WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS_TEXT, tokens);
            }
            checkIfNumbersBetween(1, 45, tokens);
            checkIfNumbersIs6UniqueNumbers(tokens);

            return tokens;
        } catch (NumberFormatException e) {
            throw new InvalidWinningNumbersException(
                    WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT, input, e);
        }
    }

    private static int getValidBonusNumber(List<Integer> numbers) {
        try {
            String input = Console.readLine();
            return convertToBonusNumber(input, numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_TEXT_FORMAT.format(e.getMessage()));
            return getValidBonusNumber(numbers);
        }
    }

    private static int convertToBonusNumber(String input, List<Integer> numbers) {
        try {
            int bonusNumber = Integer.parseInt(input);
            checkIfNumberBetween(1, 45, bonusNumber);
            checkIfNumberIsInWinningNumber(bonusNumber, numbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new InvalidBonusNumberException(BONUS_NUMBER_CANNOT_CONVERT_TO_INTEGER_TEXT, input, e);
        }
    }

    private static void checkIfNegativeLong(long purchasedAmount) {
        if (purchasedAmount < 0) {
            throw new InvalidPurchasedAmountException(PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT,
                    purchasedAmount);
        }
    }

    private static void checkIfDivisibleByLotteryPrice(long purchasedAmount) {
        if (purchasedAmount % 1000 != 0 || purchasedAmount == 0) {
            throw new InvalidPurchasedAmountException(PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT,
                    purchasedAmount);
        }
    }

    private static void checkIfNumbersBetween(int startInclusive, int endInclusive, List<Integer> numbers) {
        for (int number : numbers) {
            if (number < startInclusive || number > endInclusive) {
                throw new InvalidWinningNumbersException(WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45_TEXT, numbers);
            }
        }
    }

    private static void checkIfNumbersIs6UniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            uniqueNumbers.add(number);
        }
        if (uniqueNumbers.size() != 6 || numbers.size() != 6) {
            throw new InvalidWinningNumbersException(WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS_TEXT, numbers);
        }
    }

    private static void checkIfNumberBetween(int startInclusive, int endInclusive, int number) {
        if (number < startInclusive || number > endInclusive) {
            throw new InvalidBonusNumberException(BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45_TEXT, number);
        }
    }

    private static void checkIfNumberIsInWinningNumber(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new InvalidBonusNumberException(BONUS_NUMBER_SHOULD_NOT_IN_WINNING_NUMBERS_TEXT, number);
        }
    }
}
