package lotto.domain.lottery;

import java.util.List;

public class LottoResult {
    private final List<Integer> matchingCounts;

    private LottoResult(
            Lottos lottos,
            Prize prize
    ) {
        Lotto prizeNumbers = prize.getPrizeNumbers();
        this.matchingCounts = lottos.generatePrizeResult(prizeNumbers);
    }

    public static LottoResult of(
            final Lottos lottos,
            final Prize prize
    ) {
        return new LottoResult(lottos, prize);
    }

    public List<Integer> getSameNumberCounts() {
        return matchingCounts;
    }
}
