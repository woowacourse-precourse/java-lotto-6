package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateEmpty(numbers);
        validateSixNumbersCount(numbers);
        validateInvalidLottoNumberRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateEmpty(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number.equals(0)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 비었습니다.");
            }
        }
    }

    private void validateSixNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 6개여야 합니다.");
        }
    }

    private void validateInvalidLottoNumberRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또의 번호는 1~45 사이의 수여야 합니다.");
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        List<Integer> checkNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (checkNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또의 각 번호는 중복될 수 없습니다.");
            }
            checkNumbers.add(number);
        }
    }
}
