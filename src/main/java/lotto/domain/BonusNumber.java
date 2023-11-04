package lotto.domain;

public class BonusNumber {
    private int bonusNumber;

    public void setBonusNumber(int inputBonusNumber) {
        bonusNumber = inputBonusNumber;
    }

    public boolean isMatchedWithBonusNumber(int lottoNumber) {
        return bonusNumber == lottoNumber;
    }
}
