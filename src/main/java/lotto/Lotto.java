package lotto;

import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> validated = new ArrayList<>();

        validateSize(numbers);
        for (int number : numbers) {
            validateNumRange(number);
            validateNonDuplicate(validated, number);
            validated.add(number);
        }
        Collections.sort(validated);
        this.numbers = validated;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WinningLotto.ERROR_NOT_SIX_TEXT);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    private static void validateNumRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(WinningLotto.ERROR_NOT_IN_RANGE_TEXT);
        }
    }

    private static void validateNonDuplicate(List<Integer> validated, int current) {
        if (validated.contains(current)) {
            throw new IllegalArgumentException(WinningLotto.ERROR_DUPLICATE_NUM_TEXT);
        }
    }
}
