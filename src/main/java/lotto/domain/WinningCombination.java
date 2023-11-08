package lotto.domain;

import lotto.validator.system.domain.WinningCombinationValidator;

import java.util.List;

public class WinningCombination {
    private final WinningLottoNumbers winningLottoNumbers;
    private final BonusNumber bonusNumeber;

    public WinningCombination(WinningLottoNumbers winningLottoNumbers, BonusNumber bonusNumeber){
        WinningCombinationValidator.validateWinningCombination(winningLottoNumbers, bonusNumeber);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumeber= bonusNumeber;
    }

    public List<Integer> getWinningNumbers() {
        return winningLottoNumbers.getNumbers();
    }

    public int getBonusNumber(){
        return bonusNumeber.getBonusNumber();
    }

}
