package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {
    private final Map<Prize, Integer> prizeResult;

    public PrizeResult() {
        prizeResult = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values()).forEach(prize -> prizeResult.put(prize, 0));
    }

    public void calculateResult(WinningLotto winningLotto, Lottos lottos) {
        lottos.getLottos().forEach(lotto -> {
            Prize prize = Prize.getPrize(lotto.getMatchLottoNumber(winningLotto),
                    lotto.isContain(winningLotto.getBonusNumber()));
            updatePrizeCount(prize);
        });
    }

    private void updatePrizeCount(Prize prize) {
        prizeResult.compute(prize, (key, value) -> value == null ? 1 : value + 1);
    }

    public Integer getPrizeCount(Prize prize) {
        return prizeResult.get(prize);
    }
}
