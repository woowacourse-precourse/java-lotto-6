package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class BonusNumber {
    private final static String errorMessageRange = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final static String errorMessageDuplicate = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final static int winningSize = 7;
    private final static int startNumber = 1;
    private final static int endNumber = 45;

    private final int bonus;

    public int getBonus() {
        return bonus;
    }

    public BonusNumber(int bonus, Lotto lotto) {
        validate(bonus, lotto);
        this.bonus = bonus;
    }

    private void validate(int numbers, Lotto lotto) {
        validateRange(numbers);
        validateDuplicate(numbers, lotto);
    }

    private void validateRange(int number) {
        if (number < startNumber || number > endNumber) {
            throw new IllegalArgumentException(errorMessageRange);
        }
    }

    private void validateDuplicate(int number, Lotto lotto) {
        Set<Integer> notDuplicate = new HashSet<>(lotto.getNumbers());
        notDuplicate.add(number);
        if (notDuplicate.size() != winningSize) {
            throw new IllegalArgumentException(errorMessageDuplicate);
        }
    }
}
