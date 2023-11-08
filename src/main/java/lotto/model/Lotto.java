package lotto.model;

import static lotto.utils.Constants.END_LOTTO_NUMBER;
import static lotto.utils.Constants.LOTTO_SIZE;
import static lotto.utils.Constants.START_LOTTO_NUMBER;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final String ERROR_NOT_CORRECT_SIZE = "[ERROR] 로또 넘버는 6개여야 합니다.";
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
        if (numbers.size() != LOTTO_SIZE) {
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
        Set<Integer> duplicateSet = new HashSet<>();
        numbers.stream()
                .filter(number -> !duplicateSet.add(number))
                .findFirst()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ERROR_NOT_DUPLICATE);
                });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
