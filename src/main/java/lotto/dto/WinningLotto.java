package lotto.dto;

import java.util.List;
import lotto.validator.LottoNumbersValidator;

public record WinningLotto(Lotto winningLotto, int bonusNumber) {

    public WinningLotto {
        LottoNumbersValidator.validateBonus(winningLotto.getNumbers(), bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLotto.getNumbers();
    }

}


