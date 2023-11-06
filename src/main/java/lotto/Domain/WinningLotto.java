package lotto.Domain;

import java.util.List;
import lotto.Domain.Validator.WinningLottoValidator;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        WinningLottoValidator.validateWinningNumbers(winningNumbers);
        WinningLottoValidator.validateBonusNumber(winningNumbers,bonusNumber);
    }
}
