package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;

        validateNumbers(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumberOfDigits(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumbers(numbers);
    }
    
    private void validateNumberOfDigits(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 로또 번호를 입력하세요.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
