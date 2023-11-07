package lotto;

import java.util.Map.Entry;
import lotto.model.Lottos;
import lotto.model.WinningGrade;
import lotto.model.WinningLotto;
import lotto.model.WinningStatics;

public class LottoCalculator {

    private static final int PERCENT_FACTOR = 100;

    public WinningStatics getWinningStatic(
            Lottos lottos,
            WinningLotto winningLotto
    ) {
        WinningStatics statics = new WinningStatics();

        lottos.getLottos().forEach(lotto -> {
            WinningGrade winningGrade = winningLotto.matchLotto(lotto);
            statics.addWinningCount(winningGrade);
        });

        return statics;
    }

    public int getWinningProfit(WinningStatics statics) {
        return statics.getStatics()
                .entrySet()
                .stream()
                .mapToInt(this::getProfit)
                .sum();
    }

    public float getProfitRate(int profit, int price) {
        return ((float) profit / price) * PERCENT_FACTOR;
    }

    private int getProfit(Entry<WinningGrade, Integer> entry) {
        return entry.getKey().getWinningPrice() * entry.getValue();
    }

}
