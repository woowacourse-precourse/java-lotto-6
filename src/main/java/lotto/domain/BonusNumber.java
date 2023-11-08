package lotto.domain;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        this.bonusNumber = number;
    }

    public static BonusNumber consistOf(String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
