package lotto.domain;

import java.util.*;

public class WinningNumbers {
    private final int LOWER_BOUND_NUMBER = 1;
    private final int UPPER_BOUND_NUMBER = 45;
    private final int LOTTO_SIZE = 6;
    private final List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        validateRange(winningNumbers);
        validateDuplicated(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(String inputString) {
        List<Integer> winningNumbers = convertInputToWinningNumbers(inputString);

        return new WinningNumbers(winningNumbers);
    }

    public static List<Integer> convertInputToWinningNumbers(String inputString) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String splitNumber : inputString.split(",")) {
            validateNumeric(splitNumber);
            winningNumbers.add(Integer.parseInt(splitNumber));
        }

        return winningNumbers;
    }

    private static void validateNumeric(String splitNumber) {
        if (!splitNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isInRange = numbers.stream()
                .allMatch(n -> n >= LOWER_BOUND_NUMBER && n <= UPPER_BOUND_NUMBER);

        if (!isInRange) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean isUnique = numbers.stream().allMatch(n -> uniqueNumbers.add(n));

        if (!isUnique) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
