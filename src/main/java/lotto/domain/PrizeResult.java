package lotto.domain;

import static lotto.domain.formatter.PrizeResultFormatter.formatPrizeResult;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {
    private final Map<Prize, Integer> prizeResult;

    public PrizeResult() {
        prizeResult = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> prizeResult.put(prize, 0));
    }

    public void calculatePrizeResult(WinningLotto winningLotto, UserLotto userLotto) {
        for (Lotto lotto : userLotto.getUserLottoNumbers()) {
            Prize rank = Prize.getLottoResult(lotto.getMatchLottoNumber(winningLotto),
                    lotto.isContain(winningLotto.getBonusNumber()));
            updateRankCount(rank);
        }
    }

    private void updateRankCount(Prize prize) {
        prizeResult.put(prize, prizeResult.get(prize) + 1);
    }

    public double sumWinningPrize() {
        double totalWinningPrize = 0.0;
        for (Prize prize : Prize.values()) {
            totalWinningPrize += prizeResult.get(prize) * prize.getWinningPrize();
        }
        return totalWinningPrize;
    }

    @Override
    public String toString() {
        return formatPrizeResult(prizeResult);
    }
}
