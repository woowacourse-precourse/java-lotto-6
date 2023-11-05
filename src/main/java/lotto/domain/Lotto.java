package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateUniqueNumber(numbers);
        validateCorrectRange(numbers);
    }

    private void validateCorrectRange(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45);

        if (!isValid) {
            throw new IllegalArgumentException("[ERROR] : 숫자가 1에서 45 사이의 범위를 벗어납니다.");
        }
    }

    private void validateUniqueNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("중복된 숫자가 존재합니다: " + number);
            }
        }
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] : 로또 개수는 6개여야 합니다");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
