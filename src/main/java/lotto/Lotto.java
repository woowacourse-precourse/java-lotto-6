package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.lottoUI.ERRORUI;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

        WinningStatistics winningStatistics = new WinningStatistics(Collections.singletonList(this));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERRORUI.InputSixNumberError());
        }

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERRORUI.CategoryOfValueError());
            }
        }

        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ERRORUI.SameNumberExistError());
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}