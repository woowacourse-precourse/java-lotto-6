package lotto.domain;

import static lotto.message.MessageConstants.LOTTO_MAX_NUMBER;
import static lotto.message.MessageConstants.LOTTO_MIN_NUMBER;
import static lotto.message.MessageConstants.LOTTO_SIZE;

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
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6자리의 로또 번호를 입력하세요.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)) {
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
