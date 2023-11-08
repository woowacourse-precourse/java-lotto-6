package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WinningNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private final Lotto winningNumber;
    private final Integer bonusNumber;

    public WinningNumber(List<Integer> winningNumber, Integer bonusNumber) {
        validateWinningNumbers(winningNumber);
        validateBonusNumber(winningNumber, bonusNumber);
        this.winningNumber = new Lotto(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public static void validateWinningNumbers(List<Integer> numbers) {
        validateDuplicate(numbers);
        for (int number : numbers) {
            validateRangeNumber(number);
            validateNumeric(String.valueOf(number));
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumber, int bonus) {
        validateNumeric(String.valueOf(bonus));
        validateRangeNumber(bonus);
        validateDuplicateAboutBonus(winningNumber, bonus);
    }

    private static void validateNumeric(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRangeNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicateAboutBonus(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean isContain(int number) {
        return winningNumber.isContain(number);
    }
}
