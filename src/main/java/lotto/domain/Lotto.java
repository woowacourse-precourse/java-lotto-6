package lotto.domain;

import java.util.List;

public class Lotto {

    // TODO: 인스턴스 변수 추가 불가.
    // TODO: 패키지 변경 가능.
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // TODO: 접근제한자 private 변경 불가.
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}
