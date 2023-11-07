package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    List<Integer> numbers;
    int bonusNum;

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
