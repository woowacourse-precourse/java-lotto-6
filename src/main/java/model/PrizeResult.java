package model;

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

    public void calculateResult(WinningLotto winningLotto, PurchasedLottos lottos) {
        lottos.getLottos().forEach(lotto -> updatePrizeCount(Prize.getPrize(
                lotto.getMatchLottoNumber(winningLotto), lotto.isContain(winningLotto.getBonusNumber()))));
    }


    private void updatePrizeCount(Prize prize) {
        prizeResult.put(prize, prizeResult.get(prize) + 1);
    }

    public Integer getPrizeCount(Prize prize) {
        return prizeResult.get(prize);
    }
}
