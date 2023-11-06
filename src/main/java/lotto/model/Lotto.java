package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
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

    private static void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 6개여야 합니다.");
        }
    }

    private static void isCorrectRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        });
    }

    private static void isDuplicate(List<Integer> numbers) {
        List<Integer> duplicate = new ArrayList<>();
        for (Integer number : numbers) {
            if (duplicate.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 있으면 안됩니다.");
            }
            duplicate.add(number);
        }
    }

}
