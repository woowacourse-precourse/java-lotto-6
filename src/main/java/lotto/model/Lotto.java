package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        rangeCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리 입니다.");
        }
    }

    private void duplicateCheck(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복입니다.");
        }
    }

    private void rangeCheck(List<Integer> numbers) {
        for (Integer Num : numbers) {
            if (Num < 1 || Num > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자 범위 오류입니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
}
