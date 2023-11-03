package lotto.Controller;

import java.util.HashSet;
import java.util.Set;

public class WinningNumberValidator implements Validator {
    static private final int VALID_LOTTO_NUMBER_COUNT = 6;
    static private final int MIN_LOTTO_NUMBER = 1;
    static private final int MAX_LOTTO_NUMBER = 45;


    @Override
    public void validate(String winningNumbers) throws IllegalArgumentException {
        String[] splitWinningNumbers = winningNumbers.split(",");
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
        if (splitWinningNumbers.length != VALID_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private int getNumericWinningNumber(String winningNumber) {
        try {
            return Integer.parseInt(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void isInRange(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
        if (lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplication(Set<Integer> validLottoNumbers) {
        if (validLottoNumbers.size() != VALID_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }


}
