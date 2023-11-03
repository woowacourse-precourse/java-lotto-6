package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {
    private final Map<Prize, Integer> prizeResult;

    public PrizeResult() {
        prizeResult = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(rank -> prizeResult.put(rank, 0));
    }

    public void calcPrizeResult(WinningLotto winningLotto, UserLotto userLotto) {
        for (Lotto lotto : userLotto.getUserLottoNumber()) {
            Prize rank = Prize.getLottoResult(lotto.getMatchLottoNumber(winningLotto),
                    lotto.isContain(winningLotto.getBonusNumber()));
            updateRankCount(rank);
        }
    }

    private void updateRankCount(Prize rank) {
        prizeResult.put(rank, prizeResult.get(rank) + 1);
    }

    public Integer getPrizeCount(Prize rank) {
        return prizeResult.get(rank);
    }

    public Map<Prize, Integer> getPrizeResult() {
        return prizeResult;
    }
}
