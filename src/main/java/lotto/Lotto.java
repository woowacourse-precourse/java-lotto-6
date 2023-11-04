package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    //접근 제어자 변경 불가능
    //필드(인스턴스 변수) 추가 불가능

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[]");
        }
    }

    // TODO: 추가 기능 구현
}
