package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] : 입력된 숫자의 갯수가 6개가 아닙니다.");
        }
    }

    public void test() {
        System.out.println(numbers);
    }

    // TODO: 추가 기능 구현
}
