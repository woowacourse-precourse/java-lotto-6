package lotto.domain;

import lotto.validator.LottoNumberValidator;

import java.util.List;

public class WinningNumber {

    private static WinningNumber winningNumber =null;
    private static List<Integer> winningNumbers = null;


    private WinningNumber(List<Integer> winningNumbers) {
        LottoNumberValidator.validateLottoSize(winningNumbers);
        LottoNumberValidator.validateDuplication(winningNumbers);
        LottoNumberValidator.validateNumberRangeInLotto(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumber create(List<Integer> winningNumbers) {
        if(winningNumber == null){
            winningNumber = new WinningNumber(winningNumbers);
        }
        return winningNumber;
    }

    public static List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
