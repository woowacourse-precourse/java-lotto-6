package lotto.domain;

import lotto.domain.constant.LottoPrize;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private static final double PERCENT = 100.0;
    private static final double ROUNDING_SCALE = 10.0;
    private List<LottoPrize> lottoPrizes;

    private LottoResult(List<LottoPrize> lottoPrizes) {
        this.lottoPrizes = lottoPrizes;
    }

    public static LottoResult createLottoResult(WinningLotto winningLotto, List<Lotto> lottos) {
        List<LottoPrize> lottoPrizes = lottos.stream()
                .map(lotto -> getEachLottoResult(winningLotto, lotto))
                .collect(Collectors.toList());

        Collections.unmodifiableList(lottoPrizes);

        return new LottoResult(lottoPrizes);
    }

    public List<LottoPrize> getLottoPrizes() {
        return lottoPrizes;
    }

    public double calculateProfitOnInvestment(Money money) {
        double totalPrizeMoney = lottoPrizes.stream()
                .mapToDouble(lottoPrize -> lottoPrize.getPrizeMoney())
                .sum();

        double rateOfReturn = money.returnOfProfitRate(totalPrizeMoney);

        return Math.round(rateOfReturn * PERCENT * ROUNDING_SCALE) / ROUNDING_SCALE;
    }

    private static LottoPrize getEachLottoResult(WinningLotto winningLotto, Lotto lotto) {
        int matchCount = winningLotto.countMatchLotto(lotto);
        boolean hasBonus = winningLotto.matchBonusNum(lotto);

        return LottoPrize.getLottoPrize(matchCount, hasBonus);
    }

}
