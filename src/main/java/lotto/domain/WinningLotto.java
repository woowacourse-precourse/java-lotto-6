package lotto.domain;

import static lotto.constants.Constants.LOTTO_SIZE;
import static lotto.constants.Constants.MAX_VALUE;
import static lotto.constants.Constants.MIN_VALUE;
import static lotto.constants.MessageConstants.INVALID_LOTTO_COUNT_ERROR;
import static lotto.constants.MessageConstants.NOT_INTEGER_ERROR;
import static lotto.constants.MessageConstants.NOT_POSITIVE_ERROR;
import static lotto.constants.MessageConstants.UNIQUE_BONUS_ERROR;
import static lotto.constants.MessageConstants.UNIQUE_ERROR;
import static lotto.constants.MessageConstants.VALID_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.utils.InputValidator;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bonusNumber;


    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Lotto createWinningNumbers(String winningNumbers) {
        InputValidator.validateNull(winningNumbers);
        InputValidator.validateEmpty(winningNumbers);
        List<Integer> numbers = parseNumbers(winningNumbers);
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
        return new Lotto(numbers);
    }

    public static int createBonusNumber(Lotto winningNumbers, String bonusNumber) {
        InputValidator.validateNull(bonusNumber);
        InputValidator.validateEmpty(bonusNumber);
        int parsedNumber = parseNumber(bonusNumber);
        validateSingleRange(parsedNumber);
        if (winningNumbers.isExist(parsedNumber)) {
            throw new IllegalArgumentException(UNIQUE_BONUS_ERROR);
        }
        return parsedNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private static List<Integer> parseNumbers(String numbers) {
        return Stream.of(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int parseNumber(String number) {
        int parsedNumber;
        try {
            parsedNumber = Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR);
        }
        if (parsedNumber <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR);
        }
        return parsedNumber;
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT_ERROR);
        }
    }

    private static void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(UNIQUE_ERROR);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateSingleRange(number);
        }
    }

    private static void validateSingleRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(VALID_RANGE);
        }
    }

    public List<Integer> getCurrentWinningNumbers() {
        return winningNumbers.getCurrentNumbers();
    }
}
