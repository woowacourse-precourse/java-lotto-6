package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ExceptionText;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            numbersCheck(uniqueNumbers, number);
        }
    }
    private void numbersCheck(Set<Integer> uniqueNumbers, int number) {
        ScopeCheck(number);
        DuplicateCheck(uniqueNumbers, number);
        uniqueNumbers.add(number);
    }

    private void ScopeCheck(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이어야 합니다.");
        }
    }

    private void DuplicateCheck(Set<Integer> uniqueNumbers, int number) {
        if (uniqueNumbers.contains(number)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }
}
