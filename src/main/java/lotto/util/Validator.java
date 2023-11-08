package lotto.util;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import static lotto.util.ErrorMessage.*;

public class Validator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[1-9]\\\\d*");
    private static final Pattern LOTTO_INPUT_PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");



    public Validator() {
    }

    public static void checkBudget(int budget) {
        if (budget % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(BUDGET.getErrorMessage());
        }
    }

    public static void checkNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE.getErrorMessage());
        }
    }

    public static void checkDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> checkNumbers = new HashSet<>(numbers);
        if (checkNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE.getErrorMessage());
        }
    }

    public static void checkNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkNumberRange(number);
        }
    }

    public static void checkNumberRange(int number) {
        if (!isValidNumberRange(number)) {
            throw new IllegalArgumentException(NUMBER_RANGE.getErrorMessage());
        }
    }

    public static void checkBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER.getErrorMessage());
        }
    }

    private static boolean isValidNumberRange(int number) {
        return number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER;
    }

    public static void checkInputBudget(String inputNumber) {
        if (!NUMBER_PATTERN.matcher(inputNumber).matches()) {
            throw new IllegalArgumentException(INPUT_BUGET.getErrorMessage());
        }
    }

    public static void checkInputBonusNumber(String inputNumber) {
        if (!NUMBER_PATTERN.matcher(inputNumber).matches()) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER.getErrorMessage());
        }
    }

    public static void checkInputLottoNumber(String inputLotto) {
        if (!LOTTO_INPUT_PATTERN.matcher(inputLotto).matches()) {
            throw new IllegalArgumentException(INPUT_LOTTO_NUMBER.getErrorMessage());
        }
    }

    public static void checkIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getErrorMessage());
        }
    }

}
