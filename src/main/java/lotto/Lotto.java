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
            System.out.println("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
