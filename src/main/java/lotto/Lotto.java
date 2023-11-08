package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isListLength6(numbers);
        isListNumbersValid(numbers);
        isListNumbersUnique(numbers);
        this.numbers = numbers;
    }

    private void isListLength6(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 수를 뽑아야합니다");
        }

    }

    public void isListNumbersValid(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalStateException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다");
            }
        }

    }

    public void isListNumbersUnique(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers,number)>1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야합니다");
            }
        }

    }

}