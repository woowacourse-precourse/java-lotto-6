package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final int MAX_LOTTO_SIZE = 6;
    private final String ERROR_NOT_CORRECT_SIZE = "[ERROR] 로또 넘버는 6개여야 합니다.";
    private final int START_LOTTO_NUMBER = 1;
    private final int END_LOTTO_NUMBER = 45;
    private final String ERROR_NOT_CORRECT_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final String ERROR_NOT_DUPLICATE = "[ERROR] 로또 번호는 중복이 있으면 안됩니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        isCorrectRange(numbers);
        isCorrectSize(numbers);
        isDuplicate(numbers);
    }

    private void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_NOT_CORRECT_SIZE);
        }
    }

    private void isCorrectRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < START_LOTTO_NUMBER || number > END_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ERROR_NOT_CORRECT_RANGE);
            }
        });
    }

    private void isDuplicate(List<Integer> numbers) {
        List<Integer> duplicate = new ArrayList<>();
        for (Integer number : numbers) {
            if (duplicate.contains(number)) {
                throw new IllegalArgumentException(ERROR_NOT_DUPLICATE);
            }
            duplicate.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
