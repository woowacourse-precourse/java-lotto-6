package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.amount.TotalAmount;

public class LottoStatistic {

    private final Map<LottoPrize, Integer> winningCounts = new HashMap<>();
    private TotalAmount totalAmount = TotalAmount.initial();

    private LottoStatistic() {
    }

    public static LottoStatistic initial() {
        return new LottoStatistic();
    }

    public void calculateWinningStatistics(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.asList()) {
            LottoPrize prize = winningLotto.matches(lotto);
            totalAmount.addLottoPrize(prize);
            winningCounts.put(prize, winningCounts.getOrDefault(prize, 0) + 1);
        }
    }
}
