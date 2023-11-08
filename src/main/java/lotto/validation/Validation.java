package lotto.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.PatternSyntaxException;
import lotto.view.exception.DuplicateBonusNumberException;
import lotto.view.exception.DuplicateNumberException;
import lotto.view.exception.InvalidDivision;
import lotto.view.exception.InvalidLottoSizeException;
import lotto.view.exception.InvalidNumberException;
import lotto.view.exception.InvalidNumberRangeException;
import lotto.view.exception.InvalidStringSplitException;
import lotto.view.exception.InvalidZeroException;

public class Validation {
    private static final int MIN_NUMBER = 1;
    private static final int SIZE = 6;
    private static final int MAX_NUMBER = 45;
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;

    public static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new InvalidLottoSizeException();
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new DuplicateNumberException();
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new InvalidNumberRangeException();
            }
        }
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidNumberRangeException();
        }

    }

    public static int isInvalidNumber(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

    public static void isZeroInput(int amount) {
        if (amount == ZERO) {
            throw new InvalidZeroException();
        }
    }

    public static void isNotDivisible(int amount) {
        if (amount % THOUSAND != ZERO) {
            throw new InvalidDivision();
        }
    }

    public static List<String> validateStringForSplit(String winningNumber) {
        try {
            return List.of(winningNumber.split(","));
        } catch (PatternSyntaxException e) {
            throw new InvalidStringSplitException();
        }
    }

    public static void isNumberInList(List<Integer> winningNumbers, int validNumber) {
        if (winningNumbers.contains(validNumber)) {
            throw new DuplicateBonusNumberException();
        }
    }

    public static List<Integer> validateWinnerNumbers(List<String> winningNumber) {
        List<Integer> validNumbers = new ArrayList<>();
        for (String numberString : winningNumber) {
            validNumbers.add(isInvalidNumber(numberString));
        }
        return validNumbers;
    }

    public static int validateBonusNumber(List<Integer> winningNumbers, String bounsNumber) {
        int validNumber = isInvalidNumber(bounsNumber);
        validateNumberRange(validNumber);
        isNumberInList(winningNumbers, validNumber);
        return validNumber;
    }
}
