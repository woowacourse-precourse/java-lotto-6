package lotto.domain;

import java.util.List;

public class DrawResultBuilder {
    private List<Integer> numbers;
    private Integer bonusNumber;

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public DrawResult build() {
        if (numbers == null) {
            throw new IllegalStateException();
        }
        if (bonusNumber == null) {
            throw new IllegalStateException();
        }
        try {
            return new DrawResult(numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
