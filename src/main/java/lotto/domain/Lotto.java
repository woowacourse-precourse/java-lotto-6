package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 제외한 로또 번호는 6개 입니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복이 있을 수 없습니다.");
        }
    }

    private boolean hasDuplication(List<Integer> numbers) {
        return numbers.stream().distinct().count() != 6;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
