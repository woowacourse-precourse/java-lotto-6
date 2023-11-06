package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Bonus {

    private final List<Integer> numbers;

    public Bonus(List<Integer> numbers) {
        validate(numbers);
        rangeCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 1) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1자리 입니다.");
        }
    }

    private void rangeCheck(List<Integer> numbers) {
        for (Integer Num : numbers) {
            if (Num < 1 || Num > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자 범위 오류입니다.");
            }
        }
    }
}
