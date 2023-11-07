package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private Integer countSameNumber(WinningNumber winningNumber) {
        int count = 0;
        for (Integer number : winningNumber.getNumbers()) {
            if (numbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean checkBonus(Integer bonus) {
        return numbers.contains(bonus);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
