package lotto.domin;

import lotto.view.ExceptionMessage;

public class PlayerLottoAmount {
    private static final int LOTTO_MIN_AMOUNT = 1000;
    private static  int amount;

    public PlayerLottoAmount(String amount) {

        int amountNm = 0;
        amountNm = validateNumber(amount);
        validateAmount(amountNm);
        this.amount = amountNm;
    }
    public static int getAmount() {
        return amount;
    }


    public void validateAmount(int amountNm) {
        validateNumberZero(amountNm);
        validateDivisible(amountNm);
    }

    public void validateNumberZero(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER_ERROR.getExceptionValue());
        }

    }
    public void validateDivisible(int amount) {
        if (amount % LOTTO_MIN_AMOUNT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_NUMBER_ERROR.getExceptionValue());
        }

    }

    public int validateNumber(String amount) {

        boolean isDigit = amount.chars().allMatch(Character::isDigit);
        if (!isDigit) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR.getExceptionValue());

        }
        return Integer.parseInt(amount);
    }


}
