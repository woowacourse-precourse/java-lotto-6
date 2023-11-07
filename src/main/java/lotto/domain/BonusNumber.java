package lotto.domain;

public class BonusNumber {

    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("1 - 45의 숫자를 입력해 주세요");
        }
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
