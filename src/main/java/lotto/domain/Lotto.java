package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers); //money는 input일때 단 한번만 객체르 생성하지만 lotto는 입력일때, 랜덤생성될때 여러 방면에서 객체가 생성되므로 생성자에서 유효검사를 하는게 좋다
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
