package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.util.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복할 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> LottoConstants.isNumberInRange(number))
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                });
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() < numbers.size();
    }

    protected List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
