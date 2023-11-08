package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Lottery {
    private final Map<Prize, Integer> prizeResult;

    public Lottery() {
        prizeResult = new EnumMap<Prize, Integer>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> prizeResult.put(prize, 0));
    }

    public void calcPrizeResult(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Prize prize = Prize.getPrize(lotto.getMatchingCount(winningLotto)
                    , lotto.isContain(winningLotto.getBonusNumber()));
            setPrizeCount(prize);
        }
    }

    public Integer getPrizeCount(Prize prize) {
        return prizeResult.get(prize);
    }

    private void setPrizeCount(Prize prize) {
        prizeResult.put(prize, prizeResult.get(prize) + 1);
    }
}
