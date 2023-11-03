package lotto.model;

public class Bonus {

    private final Integer bonusNumber;

    public Bonus(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    
    public Boolean hasBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
