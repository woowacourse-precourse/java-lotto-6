package lotto.Domain;

import java.util.List;
import lotto.Domain.Validator.WinningLottoValidator;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, BonusNumber bonusNumber) {
        WinningLottoValidator.doValidate(winningLotto, bonusNumber);
    }
}
