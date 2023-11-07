package lotto.domain.winningNumber;

public class BonusNumber {

    final int bonusNumber;

    public BonusNumber(String input) {
        validate(input);
        bonusNumber = Integer.parseInt(input);
    }

    public void validate(String input) {
        WinningNumberValidator.validateNumericInput(input);
        WinningNumberValidator.validateValueInRange(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
