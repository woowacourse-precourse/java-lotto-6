package lotto.domain;

import java.util.List;

import static lotto.grobal.LottoConstants.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNoDuplicate(numbers);
        validateNumberInRange(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 입력한 숫자의 개수가 올바르지 않습니다. 6개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        long uniqueCount = numbers.stream().distinct().count();
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다. 1부터 45 사이의 서로 다른 숫자 6개를 입력해주세요.");
        }
    }

    private void validateNumberInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
