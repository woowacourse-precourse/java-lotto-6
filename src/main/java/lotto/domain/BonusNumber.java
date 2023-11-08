package lotto.domain;

public class BonusNumber extends Validator{

    private Integer bonusNumber;

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String input) {
        int bonusNumber = parseInt(input);
        validateRangeOfNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
