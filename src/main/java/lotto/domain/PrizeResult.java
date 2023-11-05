package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;

public class PrizeResult {
    EnumMap<Prize, Integer> result = new EnumMap<>(Prize.class);

    public PrizeResult(Lottos lottos, WinningLotto winningLotto) {
        Arrays.stream(Prize.values()).forEach(prize -> result.put(prize, 0));

        lottos.getLottos().forEach(lotto ->
                updatePrizeCount(calculatePrize(lotto, winningLotto))
        );
    }

    public EnumMap<Prize, Integer> getResult() {
        return result;
    }

    private Prize calculatePrize(Lotto lotto, WinningLotto winningLotto) {
        return Prize.getPrizeByCount(
                lotto.calculateMatchCount(winningLotto.getWinningLotto()),
                lotto.isContain(winningLotto.getBonusNumber())
        );
    }

    private void updatePrizeCount(Prize prize) {
        result.put(prize, result.get(prize) + 1);
    }
}
