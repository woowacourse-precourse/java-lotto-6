package lotto.domain;

public class BonusNumber {

    private int bonusNumber;

    public BonusNumber() {
        bonusNumber = readBonusNumber();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
