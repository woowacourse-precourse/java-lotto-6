package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.domain.Constant.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateInRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        for (int num : numbers) {
            int cnt = Collections.frequency(numbers, num);
            if (cnt >= 2)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
        }
    }

    private void validateInRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num > MAX_LOTTO_NUMBER || num < MIN_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1 ~ 45 입니다.");
            }
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6자리 입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
