package lotto.domain;

import java.util.Collection;
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

    public LotteryResults getResultFrom(PurchasedLottery lottery, Collection<? extends LotteryRanking> rankings) {
        int counts = lotto.matches(lottery.getNumbers());
        boolean isBonusNumberMatch = bonusNumber.matches(lottery.getNumbers());
        LotteryRanking ranking = getRanking(rankings, counts, isBonusNumberMatch);
        return new LotteryResults(ranking, 1,rankings);
    }
    private LotteryRanking getRanking(Collection<? extends LotteryRanking> rankings, int counts, boolean isBonusNumberMatch) {
        return rankings.stream()
                .filter(ranking -> ranking.matches(counts, isBonusNumberMatch))
                .findFirst().get();
    }

}
