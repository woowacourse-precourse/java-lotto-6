package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        for (Integer number : numbers) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 양수여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}