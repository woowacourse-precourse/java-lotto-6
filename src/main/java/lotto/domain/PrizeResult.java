package lotto.domain;

import static lotto.domain.formatter.PrizeResultFormatter.formatPrizeResult;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {
    private static final int ZER0 = 0;
    private static final int ONE = 1;

    private final Map<Prize, Integer> prizeResult;

    public PrizeResult() {
        prizeResult = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> prizeResult.put(prize, ZER0));
    }

    public void calculatePrizeResult(WinningLotto winningLotto, UserLotto userLotto) {
        for (Lotto lotto : userLotto.getUserLottoNumbers()) {
            Prize rank = Prize.getLottoResult(lotto.getMatchLottoNumber(winningLotto),
                    lotto.isContain(winningLotto.getBonusNumber()));
            updateRankCount(rank);
        }
    }

    private void updateRankCount(Prize prize) {
        prizeResult.replace(prize, prizeResult.getOrDefault(prize, ZER0) + ONE);
    }

    public double sumWinningPrize() {
        return Arrays.stream(Prize.values())
                .mapToDouble(prize -> prizeResult.get(prize) * prize.getWinningPrize())
                .sum();
    }

    @Override
    public String toString() {
        return formatPrizeResult(prizeResult);
    }
}
