package lotto.model;

import java.util.List;

public class Lotto {    // 인스턴스 변수 추가 ㄴㄴ, 패키지 변경은 가능
    private final List<Integer> numbers;    // 접근 제어자 변경 ㄴㄴ

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
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
