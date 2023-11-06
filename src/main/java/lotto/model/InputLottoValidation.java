package lotto.model;

import lotto.utils.Constants;
import lotto.view.ExceptionMessage;

public class InputLottoValidation {
    private final int amount;

    public InputLottoValidation(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }

    private void validateAmount(int amount) {
        validateNatural(amount);
        validateDivisible(amount);
    }

    public int calculateLottoCount() {
        return amount / Constants.LOTTO_TICKET_PRICE;
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

    private void validateDivisible(int amount) {
        if (amount % Constants.LOTTO_TICKET_PRICE != 0) {
            ExceptionMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }
}
