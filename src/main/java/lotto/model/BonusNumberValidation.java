package lotto.model;

import lotto.view.ExceptionMessage;

public class BonusNumberValidation {
    private final int bonusNumber;

    public BonusNumberValidation(String number) {
        int amountNum = validateNumber(number);
        validateNatural(amountNum);
        this.bonusNumber = amountNum;
    }

    private static int validateNumber(String amount) {
        try{
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            ExceptionMessage.numberException();
            throw new IllegalStateException();
        }
    }

    private void validateNatural(int amount) {
        if (amount <= 0) {
            ExceptionMessage.naturalException();
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
