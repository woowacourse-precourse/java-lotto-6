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
            throw new IllegalArgumentException("[ERROR] 로또를 생성하기 위한 숫자의 개수는 6개 입니다.");
        }
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
