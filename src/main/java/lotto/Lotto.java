package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateNum(int num) {
        if(num < 0 || num > 45) {
            throw new IllegalArgumentException("[Error] 1부터 45사이 숫자만 입력하세요.");
        }
    }
}
