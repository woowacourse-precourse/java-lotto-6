package lotto.validation;

import lotto.domain.ErrorMessage;

import java.util.List;

import static lotto.domain.ErrorMessage.*;

public class Validator {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;

    public int validWinning(String winningNumber) {
        int convertWinning = checkType(winningNumber);
        checkRange(convertWinning);

        return convertWinning;
    }

    public int validBonus(String bonus, List<Integer> winningLotto) {
        int convertBonus = checkType(bonus);
        checkRange(convertBonus);
        checkContainLotto(convertBonus, winningLotto);

        return convertBonus;
    }

    private void checkContainLotto(int convertBonus, List<Integer> winningLotto) {
        if (!winningLotto.contains(convertBonus)) {
            return;
        }
        getDescription(BONUS_DUPLICATE);
        throw new IllegalArgumentException();
    }

    public int validPurchase(String amount) {
        int convertAmount = checkType(amount);
        checkRemain(convertAmount);

        return convertAmount;
    }

    public List<String> validNumbers(List<String> lottoNumbers) {
        validWinningNumber(lottoNumbers);
        if (checkSize(lottoNumbers)) {
            return lottoNumbers;
        }
        ErrorMessage.getDescription(ErrorMessage.SIZE);
        throw new IllegalArgumentException();
    }

    private void validWinningNumber(List<String> lottoNumbers) {
        lottoNumbers.stream().forEach(number -> validWinning(number));
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
        return number >= LOTTO_START && number <= LOTTO_END;
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
