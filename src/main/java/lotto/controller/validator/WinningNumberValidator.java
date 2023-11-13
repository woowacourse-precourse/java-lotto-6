package lotto.controller.validator;

import java.util.HashSet;
import java.util.Set;
import lotto.utils.GameConstants;
import lotto.utils.Message;

public class WinningNumberValidator implements Validator {

    @Override
    public void validate(String winningNumbers) throws IllegalArgumentException {
        String[] splitWinningNumbers = winningNumbers.split(GameConstants.SEPARATOR);
        Set<Integer> validLottoNumbers = new HashSet<>();

        isValidLength(splitWinningNumbers);

        for (String winningNumber : splitWinningNumbers) {
            int numericWinningNumber = getNumericWinningNumber(winningNumber);
            isInRange(numericWinningNumber);
            validLottoNumbers.add(numericWinningNumber);
        }

        checkDuplication(validLottoNumbers);
    }

    private void isValidLength(String[] splitWinningNumbers) {
        if (splitWinningNumbers.length != GameConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(Message.INVALID_LOTTO_NUMBER_COUNT_EXCEPTION);
        }
    }

    private int getNumericWinningNumber(String winningNumber) {
        try {
            return Integer.parseInt(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NON_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    private void isInRange(int lottoNumber) {
        if (lottoNumber < GameConstants.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Message.OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
        if (lottoNumber > GameConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Message.OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private void checkDuplication(Set<Integer> validLottoNumbers) {
        if (validLottoNumbers.size() != GameConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(Message.DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
