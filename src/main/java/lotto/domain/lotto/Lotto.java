package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    public Collection<Integer> getLotto() {
        return Collections.unmodifiableCollection(numbers);
    }

    private void sortNumbers(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        validateSizeOfNumbers(numbers);
        validateDuplicateNumber(numbers);
        checkValidNumbersInLotto(numbers);
    }

    private void validateSizeOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또에 6개 번호가 입력되지 않았습니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        long uniqueLottoNumSize = numbers.stream()
                .distinct()
                .count();

        if (uniqueLottoNumSize != 6) {
            throw new IllegalArgumentException("[ERROR] 로또에 중복된 번호가 존재합니다.");
        }
    }

    private void checkValidNumbersInLotto(List<Integer> numbers) {
        if (hasInvalidRangeNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean hasInvalidRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(num -> num >= 1 && num <= 45);
    }
}
