package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int MONEY_UNIT = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int WINNING_NUMBERS_COUNT = 6;

    public void validatePurchaseAmount(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
    }

    public int validateNonNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45 사이어야 합니다.");
            }
        }
    }

    public void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    public void validateWinningNumbersCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수를 만족시키지 못합니다.");
        }
    }
}
