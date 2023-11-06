package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessageConstants.LOTTO_INVALID_SIZE.getMessage());
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(LottoErrorMessageConstants.LOTTO_HAS_DUPLICATE_NUMBER.getMessage());
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);
        return notDuplicateNumbers.size() != LottoConstants.LOTTO_PER_NUMBERS.getConstant();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
