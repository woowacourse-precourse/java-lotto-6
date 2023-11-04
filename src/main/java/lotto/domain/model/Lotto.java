package lotto.domain.model;

import lotto.enums.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) { // validate validateCountNumbers
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자의 개수가 6개를 넘지 않아야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicateNumbers(List<Integer> numbers) {
        boolean hasDuplicates = false;
        Set<Integer> duplicateChecker = new HashSet<>();

        for (Integer number : numbers) {
            if (!duplicateChecker.add(number)) {
                hasDuplicates = true;
                break;
            }
        }

        if (hasDuplicates) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_HAS_DUPLICATE_NUMBERS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void showNumbers() {
        System.out.println(this.numbers);
    }
}
