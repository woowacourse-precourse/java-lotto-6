package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 로또는 6개의 정수여야 합니다.");
        }

        if (numbers.stream().distinct().collect(Collectors.toList()).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 로또는 중복되지 않은 수여야 합니다.");
        }

        if (!validateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 로또는 1에서 45 사이 정수여야 합니다.");
        }
    }

    private Boolean validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            return true;
        }
        return false;
    }

    private Boolean validateNumber(List<Integer> numbers) {
        for (int i : numbers) {
            if (validateNumberRange(i)) {
                return false;
            }
        }
        return true;
    }
}
