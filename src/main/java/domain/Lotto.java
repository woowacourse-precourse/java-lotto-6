package domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) { // 상수 처리 필요
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    // 중복 확인 기능
    public boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }
}
