package lotto;

import java.util.List;

public class Lotto {
    // 변수
    private final List<Integer> numbers;

    // 생성자
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 번호가 6개인지 검사하는 메서드
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
