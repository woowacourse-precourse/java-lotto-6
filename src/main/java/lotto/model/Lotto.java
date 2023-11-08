package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateNumbersLange(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR]로또 번호는 중복되지 않는 6개여야 합니다.");
        }
    }

    private void validateNumbersLange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR]로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
