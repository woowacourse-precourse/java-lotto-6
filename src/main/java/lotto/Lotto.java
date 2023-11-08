package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private Set<Integer> overlapValidate;
    private final int minNumber = 1;
    private final int maxNumber = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        int bonus = Input.getBonusNumber();
        bonusRangeValidate(bonus);
        Collections.sort(numbers);
        numbers.add(bonus);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            new ThrowNewException().sizeException();
        }
        rangeValidate(numbers);
    }

    // TODO: 추가 기능 구현
    private void rangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > maxNumber || number < minNumber) {
                new ThrowNewException().rangeException();
            }
        }
        overlapValidate(numbers);
    }

    private void overlapValidate(List<Integer> numbers) {
        overlapValidate = new HashSet<>();
        for (int number : numbers) {
            if (!overlapValidate.add(number)) {
                new ThrowNewException().overlapException();
            }
        }
    }

    private void bonusRangeValidate(int bonus) {
        if (bonus > maxNumber || bonus < minNumber) {
            new ThrowNewException().rangeException();
        }
        bonusOverlapValidate(bonus);
    }

    private void bonusOverlapValidate(int bonus) {
        if (!overlapValidate.add(bonus)) {
            new ThrowNewException().overlapException();
        }
    }
}
