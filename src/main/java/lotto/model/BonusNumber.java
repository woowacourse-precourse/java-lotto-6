package lotto.model;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumInput) {
        validateBonusNumber(bonusNumInput);
        this.bonusNumber = Integer.parseInt(bonusNumInput);
    }

    private void validateBonusNumber(String bonusNumInput) {

    }
}
