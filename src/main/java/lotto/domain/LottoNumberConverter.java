package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.exception.NotCommaSeparatedIntegerException;
import lotto.domain.exception.NotDigitException;
import lotto.domain.exception.NotValidBonusNumberSizeException;
import lotto.domain.exception.NotValidLottoNumberException;
import lotto.domain.exception.NotValidWinningNumberSizeException;

public class LottoNumberConverter {

    public List<Integer> convertWinningNumbers(String input) {
        checkIsCommaSeparatedDigitString(input);
        List<Integer> lottoNumbers = convertToLottoNumbers(input);
        checkIsWinningNumberSizeValid(lottoNumbers);
        checkIsLottoNumberRangeValid(lottoNumbers);

        return lottoNumbers;
    }

    public int convertBonusNumber(String input) {
        checkIsDigitString(input);
        List<Integer> lottoNumbers = convertToLottoNumbers(input);
        checkIsBonusNumberSizeValid(lottoNumbers);
        checkIsLottoNumberRangeValid(lottoNumbers);

        return lottoNumbers.get(0);
    }

    private List<Integer> convertToLottoNumbers(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String splitInput : input.split(",")) {
            lottoNumbers.add(Integer.parseInt(splitInput));
        }

        return lottoNumbers;
    }

    private void checkIsCommaSeparatedDigitString(String input) {
        for (char c : input.toCharArray()) {
            if (!isCommaOrDigit(c)) {
                throw new NotCommaSeparatedIntegerException();
            }
        }
    }

    private void checkIsDigitString(String input) {
        for (char c : input.toCharArray()) {
            if (!isDigit(c)) {
                throw new NotDigitException();
            }
        }
    }

    private void checkIsWinningNumberSizeValid(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new NotValidWinningNumberSizeException();
        }
    }

    private void checkIsBonusNumberSizeValid(List<Integer> bonusNumber) {
        if (bonusNumber.size() != 1) {
            throw new NotValidBonusNumberSizeException();
        }
    }

    private void checkIsLottoNumberRangeValid(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new NotValidLottoNumberException();
            }
        }
    }

    private boolean isCommaOrDigit(char c) {
        return c == ',' || isDigit(c);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
