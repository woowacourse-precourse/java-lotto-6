package lotto.model;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    // 이거 꼭 필요한지 생각해보기
    public boolean isEqualToBonus(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
