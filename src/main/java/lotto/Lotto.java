package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> modifiableNumbers = new ArrayList<>(numbers);
        validate(modifiableNumbers);
        Collections.sort(modifiableNumbers);
        validateNonDuplicateForSorted(modifiableNumbers);
        this.numbers = modifiableNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    private void validateNonDuplicateForSorted(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i + 1).equals(numbers.get(i))) {
                throw new IllegalArgumentException();
            }
        }
    }
}
