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
        validateSixNumbers(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> noDuplication = new HashSet<>(numbers);
        if(noDuplication.size() != numbers.size()) {
            throw new IllegalArgumentException("번호가 중복 되었습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException("번호는 1~45의 숫자여야 합니다.");
            }
        }
    }
    // TODO: 추가 기능 구현
}
