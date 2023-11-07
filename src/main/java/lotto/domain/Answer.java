package lotto.domain;

public class Answer {
    private final HitNumbers hitNumbers;
    private final int bonusNumber;

    public Answer(HitNumbers hitNumbers, int bonusNumber) {
        this.hitNumbers = hitNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isHitNumbersHaveThisNumber(int number) {
        return hitNumbers.findNumber(number);
    }

    public boolean isBonusNumberTheSameAsThis(int number) {
        return number == bonusNumber;
    }
}
