package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoConstants;
import lotto.StringConstants;
import lotto.domain.Lotto;

public class LottoWinningNumberService {
    public List<Integer> addLottoNumberToWinningNumbers(String lottoNumbersString) {
        List<Integer> winningNumbers = convertStringToWinningNumbers(lottoNumbersString);
        Lotto lotto = new Lotto(winningNumbers);

        return lotto.getNumbers();
    }

    public List<Integer> convertStringToWinningNumbers(String lottoNumbersString) {
        String[] splitNumbers = lottoNumbersString.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            try {
                lottoNumbers.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE + StringConstants.WINNING_NUMBERS_NOT_DIGIT_EXCEPTION_MESSAGE);
            }
        }
        return lottoNumbers;
    }

    public void validateBonusNumber(List<Integer> lottoWinningNumbers, String bonusNumber) {
        if (bonusNumberNotDigit(bonusNumber)) {
            throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE + StringConstants.BONUS_NUMBER_NOT_DIGIT_EXCEPTION_MESSAGE);
        }
        if (bonusNumberWrongRange(bonusNumber)) {
            throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE + StringConstants.BONUS_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
        if (bonusNumberDuplicateWinningNumbers(lottoWinningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE + StringConstants.BONUS_NUMBER_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public boolean bonusNumberNotDigit(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public boolean bonusNumberWrongRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        return number < LottoConstants.NUMBER_MIN.getValue() || number > LottoConstants.NUMBER_MAX.getValue();
    }

    public boolean bonusNumberDuplicateWinningNumbers(List<Integer> lottoWinningNumbers, String bonusNumber) {
        int bonusNumberInt = Integer.parseInt(bonusNumber);
        return lottoWinningNumbers.contains(bonusNumberInt);
    }
}
