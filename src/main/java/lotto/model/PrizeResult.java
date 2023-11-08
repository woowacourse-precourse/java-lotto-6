package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {
    private final Map<Prize, Integer> prizeResult;

    public PrizeResult() {
        prizeResult = new EnumMap<Prize, Integer>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> prizeResult.put(prize, 0));
    }

    public void calcPrizeResult(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Prize prize = Prize.getPrize(lotto.countContain(winningLotto.getWinningNumbers()),
                    lotto.containNumber(winningLotto.getBonusNumber()));
            updatePrizeCount(prize);
        }
    }

    private void updatePrizeCount(Prize prize) {
        prizeResult.put(prize, prizeResult.get(prize) + 1);
    }

    public int getPrizeCount(Prize prize) {
        return prizeResult.get(prize);
    }

}