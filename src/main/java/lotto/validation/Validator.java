package lotto.validation;

import static lotto.domain.ErrorMessage.*;

public class Validator {

    private static final int LOTTO_PRICE = 1000;

    public int validWinning(String winningNumber) {
        int convertWinning = checkType(winningNumber);
        checkRange(convertWinning);

        return convertWinning;
    }

    public int validBonus(String bonus) {
        int convertBonus = checkType(bonus);
        checkRange(convertBonus);

        return convertBonus;
    }

    public int validPurchase(String amount) {
        int convertAmount = checkType(amount);
        checkRemain(convertAmount);

        return convertAmount;
    }

    public void checkRange(int number) {
        if (isLottoRange(number)) {
            return;
        }
        getDescription(LOTTO_RANGE);
        throw new IllegalArgumentException();
    }

    private boolean isLottoRange(int number) {
        return number > 0 && number < 46;
    }

    public void checkRemain(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            getDescription(PRICE_REMAIN);
            throw new IllegalArgumentException();
        }
    }

    public int checkType(String number) {
        Integer resultNumber;
        try {
            resultNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            getDescription(TYPE_INT);
            throw new IllegalArgumentException(e);
        }
        return resultNumber;
    }
}
