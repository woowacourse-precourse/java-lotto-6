package lotto.utils;

import lotto.constant.LotteryRank;
import lotto.model.LotteryResult;
import lotto.model.Lotto;

public class LottoMachine {
    private Lotto winningLotto;

    private int bonusNumber;

    public LottoMachine(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LotteryRank calculateLotteryRank(Lotto lotto) {
        int matchingNumbersCount = winningLotto.matchingNumbersCount(lotto);
        boolean containsBonusNumber = lotto.containsNumber(bonusNumber);

        LotteryResult lotteryResult = new LotteryResult(matchingNumbersCount, containsBonusNumber);

        return LotteryRank.getLotteryRank(lotteryResult);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
