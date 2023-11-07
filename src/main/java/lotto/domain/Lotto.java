package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public Lotto(List<Integer> numbers) {
        sizeValidate(numbers);
        this.numbers = numbers;
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 문자를 입력했습니다.");
        }
    }

    private void isNumberRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
                throw new IllegalArgumentException("[ERROR] 숫자가 범위를 벗어났습니다.");
            }
        }
    }

    private void isDuplicateValidate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (!(numberSet.size() == 6)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    private boolean inNumbersValidate(int number){
        return numbers.contains(number);
    }
}
