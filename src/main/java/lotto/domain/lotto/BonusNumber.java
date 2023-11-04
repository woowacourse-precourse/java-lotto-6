package lotto.domain.lotto;

public class BonusNumber {

    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
