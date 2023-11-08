package lotto.model;

import lotto.utils.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.utils.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBERS_MIN_VALUE && number > LOTTO_NUMBERS_MAX_VALUE) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력하세요.");
            }
        }
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
