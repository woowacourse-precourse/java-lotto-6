package lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> duplicateRemoved = numbers.stream()
                .distinct()
                .toList();
        if (duplicateRemoved.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_INPUT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public void print() {
        System.out.print("[");
        for (int i = 0; i < 5; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.println(numbers.get(5) + "]");
    }

    public int calculateNumberOfMatches(List<Integer> comparisonTarget) {
        return numbers.stream()
                .filter(comparisonTarget::contains)
                .toList()
                .size();
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
