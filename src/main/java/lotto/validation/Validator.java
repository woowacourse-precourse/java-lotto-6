package lotto.validation;

import lotto.domain.ErrorMessage;

import java.util.List;

import static lotto.domain.ErrorMessage.*;

public class Validator {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;

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

    public List<String> validNumbers(List<String> lottoNumbers) {
        if (checkSize(lottoNumbers)) {
            return lottoNumbers;
        }
        ErrorMessage.getDescription(ErrorMessage.SIZE);
        throw new IllegalArgumentException();
    }

    private boolean checkSize(List<String> lottoNumbers) {
        return lottoNumbers.size() == LOTTO_SIZE;
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
