package lotto.model;


public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(String bonusNumber) {
        validate();
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate() {

    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}