package lotto.domain.wrapper;

public class BonusNumber {
    private int number;

    private BonusNumber(int bonusNumber) {
        this.number = bonusNumber;
    }

    public static BonusNumber create(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getNumber() {
        return number;
    }
}
