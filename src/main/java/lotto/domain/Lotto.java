package lotto.domain;

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

    private void isNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
                throw new IllegalArgumentException("[ERROR] 숫자가 범위를 벗어났습니다.");
            }
        }
    }
}
