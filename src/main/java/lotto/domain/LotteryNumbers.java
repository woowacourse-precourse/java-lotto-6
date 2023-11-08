package lotto.domain;

import lotto.validator.LotteryNumbersValidator;
import lotto.validator.LottoValidator;

/*
 *   당첨 번호들(담첨 번호 + 보너스 번호)의 정보를 담당
 * */

public class LotteryNumbers {

    private final Lotto winningLotto;
    private final int bonusNumber;

    private LotteryNumbers(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LotteryNumbers of(Lotto winningLotto, int bonusNumber) {
        return new LotteryNumbers(winningLotto, bonusNumber);
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        LottoValidator.numberOutValueRange(bonusNumber);
        LotteryNumbersValidator.bonusNumberDuplicated(winningLotto, bonusNumber);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
