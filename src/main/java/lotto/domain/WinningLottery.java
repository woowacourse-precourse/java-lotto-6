package lotto.domain;

import java.util.List;

public class WinningLottery {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLottery(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottery of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLottery(new Lotto(winningNumbers),
                new BonusNumber(bonusNumber));
    }

    public LotteryResults getResultFrom(PurchasedLottery lottery) {
        int counts = lotto.matches(lottery.getNumbers());
        boolean isBonusNumberMatch = bonusNumber.matches(lottery.getNumbers());
        LotteryRanking ranking = LotteryRanking.getRanking(counts, isBonusNumberMatch);
        return new LotteryResults(ranking, 1);
    }
}
