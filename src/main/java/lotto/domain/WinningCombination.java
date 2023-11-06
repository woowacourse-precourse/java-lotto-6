package lotto.domain;

import lotto.validator.system.SystemValidator;
import lotto.validator.system.WinningCombinationValidator;

import java.util.List;

public class WinningCombination {
    private final WinningLottoNumbers winningLottoNumbers;
    private final int bonusNumeber;

    public WinningCombination(WinningLottoNumbers winningLottoNumbers, int bonusNumeber){
        WinningCombinationValidator.validateWinningCombination(winningLottoNumbers, bonusNumeber);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumeber= bonusNumeber;
    }

    public List<Integer> getWinningNumbers() {
        return winningLottoNumbers.getNumbers();
    }

    public int getBonusNumber(){
        return bonusNumeber;
    }
}
