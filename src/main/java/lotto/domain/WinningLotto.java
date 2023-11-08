package lotto.domain;

import lotto.enumeration.ExceptionType;

public class WinningLotto {
    private final Lotto numbers;
    private final int bonusNum;

    public WinningLotto(Lotto numbers, int bonusNum) {
        validate(numbers, bonusNum);
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    private void validate(Lotto numbers, int bonusNum) {
        if(numbers.getNumbers().contains(bonusNum)) {
            throw new IllegalArgumentException(ExceptionType.DUPLICATE_BONUS_LOTTO.getMessage());
        }
        if(bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException(ExceptionType.EXCEED_BONUS_RANGE.getMessage());
        }
    }

    public Lotto getNumbers() {
        return numbers;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
