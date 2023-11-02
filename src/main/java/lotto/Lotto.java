package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { // 인스턴스
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) { // 사용자가 입력한 값이 6자인지 확인하는 메서드
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}