package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumberValidation.checkNumberRange(numbers);
        NumberValidation.checkDuplicatedNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
    private static class NumberValidation {
        private static void checkNumberRange(List<Integer> numbers) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자는 6자리를 입력해야 됩니다.");
            }
        }

        private static void checkDuplicatedNumber(List<Integer> numbers) {
            Set<Integer> collect = new HashSet<>(numbers);

            if (collect.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다.");
            }
        }
    }
}
