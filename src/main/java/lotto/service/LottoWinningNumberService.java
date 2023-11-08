package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.StringConstants;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoWinningNumberService {
    private Lotto addLottoNumberToWinningNumbers(String lottoNumbersString) {
        List<Integer> winningNumbers = convertStringToWinningNumbers(lottoNumbersString);

        return new Lotto(winningNumbers);
    }

    public List<Integer> convertStringToWinningNumbers(String lottoNumbersString) {
        String[] splitNumbers = lottoNumbersString.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            try {
                lottoNumbers.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        StringConstants.FIRST_ERROR_MESSAGE
                                + StringConstants.WINNING_NUMBERS_NOT_DIGIT_EXCEPTION_MESSAGE);
            }
        }
        return lottoNumbers;
    }

    public WinningLotto createWinningLotto(String lottoNumbersString, String bonusNumber) {
        Lotto winningNumbers = addLottoNumberToWinningNumbers(lottoNumbersString);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

}
