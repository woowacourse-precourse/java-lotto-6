package lotto.domain;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String bonusNumber) {
        isInteger(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
