package lotto.domain;

public class Bonus {
    int bonusNumber;

    public Bonus(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(bonusNumber);
    }
}
