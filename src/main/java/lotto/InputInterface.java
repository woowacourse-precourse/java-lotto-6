package lotto;

import static java.util.stream.Collectors.toList;
import static lotto.resource.TextResourceProvider.INPUT_DELIMITER;
import static lotto.resource.TextResourceProvider.INPUT_PURCHASE_AMOUNT_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_WINNING_NUMBERS_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidPurchasedAmountException;
import lotto.exception.InvalidWinningNumbersException;
import lotto.exception.UserInvalidInputException;

public class InputInterface {

    public long getPurchasedAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_TEXT);

        return getValidPurchasedAmount();
    }

    public List<Integer> getWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_TEXT);

        return getValidWinningNumbers();
    }

    private long getValidPurchasedAmount() {
        try {
            String input = Console.readLine();
            long purchaseAmount = convertToPurchasedAmount(input);
            return purchaseAmount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getValidPurchasedAmount();
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
        } catch (Exception e) {
            throw new UserInvalidInputException(e);
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
                        WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT, tokens);
            }
            checkIfNumbersBetween(1, 45, tokens);
            checkIfNumbersIs6UniqueNumbers(tokens);

            return tokens;
        } catch (NumberFormatException e) {
            throw new InvalidWinningNumbersException(
                    WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT, input, e);
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
                throw new InvalidWinningNumbersException(WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45, numbers);
            }
        }
    }

    private static void checkIfNumbersIs6UniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            uniqueNumbers.add(number);
        }
        if (uniqueNumbers.size() != 6 || numbers.size() != 6) {
            throw new InvalidWinningNumbersException(WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS, numbers);
        }
    }
}
