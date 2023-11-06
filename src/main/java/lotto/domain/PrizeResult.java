package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;

public class PrizeResult {
    EnumMap<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);

    public PrizeResult(Lottos lottos, WinningLotto winningLotto) {
        Arrays.stream(Prize.values()).forEach(prize -> prizeCount.put(prize, 0));

        lottos.getLottos().forEach(lotto ->
                updatePrizeCount(calculatePrize(lotto, winningLotto))
        );
    }

    public EnumMap<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public int getPrizeMoney() {
        int prizeMoney = 0;
        for (EnumMap.Entry<Prize, Integer> entry : prizeCount.entrySet()) {
            prizeMoney += (entry.getKey().getMoney() * entry.getValue());
        }
        return prizeMoney;
    }

    private Prize calculatePrize(Lotto lotto, WinningLotto winningLotto) {
        return Prize.getPrizeByCount(
                lotto.calculateMatchCount(winningLotto.getWinningLotto()),
                lotto.isContain(winningLotto.getBonusNumber())
        );
    }

    private void updatePrizeCount(Prize prize) {
        if (prize != null) {
            prizeCount.put(prize, prizeCount.get(prize) + 1);
        }
    }
}
