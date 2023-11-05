package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6 || !numbers.stream().allMatch(n -> n >= 1 && n <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 6개 숫자여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
