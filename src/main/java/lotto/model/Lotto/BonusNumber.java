package lotto.model.Lotto;

public class BonusNumber {
    private int bonusNumber;

    BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber create(String inputBonusNumber) {
        return new BonusNumber(Integer.parseInt(inputBonusNumber));
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
