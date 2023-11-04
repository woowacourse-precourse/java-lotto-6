package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        return this.numbers;
    }

    private void validateEmpty(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number.equals(0))) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 비었습니다.");
        }
    }

    private void validateSixNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 6개여야 합니다.");
        }
    }

    private void validateInvalidLottoNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 1~45 사이의 수여야 합니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>();
        if (numbers.stream().anyMatch(number -> !checkNumbers.add(number))) {
            throw new IllegalArgumentException("[ERROR] 로또의 각 번호는 중복될 수 없습니다.");
        }
    }
}
