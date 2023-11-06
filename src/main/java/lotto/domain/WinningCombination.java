package lotto.domain;

import lotto.validator.system.SystemValidator;

import java.util.List;

public class WinningCombination {
    private final WinningLottoNumbers winningLottoNumbers;
    private final int bonusNumeber;

    public WinningCombination(WinningLottoNumbers winningLottoNumbers, int bonusNumeber){
        SystemValidator.winningCombinationValidator(winningLottoNumbers, bonusNumeber);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumeber= bonusNumeber;
    }

    public List<Integer> getWinningNumbers() {
        return winningLottoNumbers.getNumbers();
    }

    public int getBonusNumeber(){
        return bonusNumeber;
    }
}
