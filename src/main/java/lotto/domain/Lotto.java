package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void checkInclusion(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해 주세요.");
        }
    }


    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.");
        }
    }

    private void checkDuplication(List<Integer> userInput) {
        if (userInput.size() != new HashSet<>(userInput).size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해 주세요.");
        }
    }
}
