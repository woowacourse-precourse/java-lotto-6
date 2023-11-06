package lotto.domain;

import lotto.validator.LottoNumberValidator;

import java.util.List;

public class WinningNumber {

    private static List<Integer> winningNumbers = null;


    public WinningNumber(List<Integer> winningNumbers) {
        LottoNumberValidator.validateLottoSize(winningNumbers);
        LottoNumberValidator.validateDuplication(winningNumbers);
        LottoNumberValidator.validateNumberRangeInLotto(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
