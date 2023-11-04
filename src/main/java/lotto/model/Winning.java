package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.Code;

public class Winning {
    private final String LACK_NUMBER_COUNT = "숫자는 6개여야 합니다.";
    private final String NUMBER_NOT_INRANGE = "번호는 1부터 45 사이의 숫자여야 합니다.";
    private final String NOT_DUPLICATED = "모든 숫자는 중복되지 않아야 합니다.";
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) {
        validateNumberCount(numbers);
        validateDuplicatedNumber(numbers);
        numbers.forEach(number -> validateNumberInRange(number, Code.WINNING.getCode()));
        this.numbers = numbers;

        validateDuplicatedWinningAndBonus(numbers, bonusNumber);
        validateNumberInRange(bonusNumber, Code.BONUS.getCode());
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LACK_NUMBER_COUNT);
        }
    }

    private void validateNumberInRange(int number, String code) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(code + NUMBER_NOT_INRANGE);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(NOT_DUPLICATED);
        }
    }

    private void validateDuplicatedWinningAndBonus(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NOT_DUPLICATED);
        }
    }
}
