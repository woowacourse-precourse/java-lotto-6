package lotto.model;

import java.util.List;

public class PrizeLotto {
    private final List<Integer> prizeNumbers;

    private final int bonusNum;

    public int getBonusNum() {
        return bonusNum;
    }

    public List<Integer> getPrizeNumbers() {
        return prizeNumbers;
    }

    public PrizeLotto(List<Integer> numbers, int bonusNum) {
        validate(numbers);
        this.prizeNumbers = numbers;
        this.bonusNum = bonusNum;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}
