package lotto.model;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNum) {
        validate(numbers);
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNum;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.winningNumbers;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }



}
