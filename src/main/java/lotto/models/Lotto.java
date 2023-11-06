package lotto.models;

import java.util.List;

public class Lotto {

    // 새 필드를 추가할 수 없다
    // 필드의 접근 제어자를 변경할 수 없다
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


}
