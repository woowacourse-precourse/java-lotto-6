package lotto.domain;

import lotto.validator.LotteryResultValidator;
import lotto.validator.LottoValidator;

public class LotteryResult {
    private final Lotto winningLotto;

    private final int bonusNumber;

    private LotteryResult(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LotteryResult of(Lotto winningLotto, int bonusNumber) {
        return new LotteryResult(winningLotto, bonusNumber);
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        LottoValidator.numberOverValueRange(bonusNumber);
        LotteryResultValidator.bonusNumberDuplicated(winningLotto.getNumbers(), bonusNumber);
    }
}
