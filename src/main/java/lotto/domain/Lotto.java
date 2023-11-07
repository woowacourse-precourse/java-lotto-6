package lotto.domain;

import java.util.List;

import static lotto.domain.Constant.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateInRange(numbers);
        this.numbers = numbers;
    }

    private void validateInRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num > MAX_LOTTO_NUMBER || num < MIN_LOTTO_NUMBER) {
                System.out.println("[ERROR] 로또 번호의 범위는 1 ~ 45 입니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            System.out.println("[ERROR] 로또 번호는 총 6자리 입니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
