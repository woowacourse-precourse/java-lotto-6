package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.view.InputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortLotto();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 생성된 숫자는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 생성된 숫자는 서로 다른 숫자여야 합니다.");
        }
        for (Integer number : uniqueNumbers) {
            if (number < InputView.MIN_LOTTO_NUMBER || number > InputView.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 생성된 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void sortLotto() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
