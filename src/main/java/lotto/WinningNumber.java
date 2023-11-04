package lotto;

import java.util.Collections;
import java.util.List;

public class WinningNumber {
    private List<Integer> numbers;
    private Integer bonusNumber;
    private static WinningNumber instance = null;
    private WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
    public static WinningNumber getInstance() {
        if (instance == null) {
            List<Integer> numbers = NumberGenerator.generateNumbers();
            Integer bonusNumber = NumberGenerator.generateNumber(numbers);
            instance = new WinningNumber(numbers, bonusNumber);
        }
        return instance;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
