package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class Statistics {

    private final Map<Prize, Integer> result;

    public Statistics(PlayerLottos playerLottos, WinningLotto winningLotto) {
        this.result = initResult();
        generateResult(playerLottos, winningLotto);
    }

    public Map<Prize, Integer> getResult() {
        return result;
    }

    private void generateResult(PlayerLottos playerLottos, WinningLotto winningLotto) {
        initResult();

        for (Lotto playerLotto : playerLottos.getPlayerLottos()) {
            int matchCount = winningLotto.calculateMatchNumber(playerLotto);
            boolean hasBonusNumber = winningLotto.hasBonusNumber(playerLotto);
            Prize prize = Prize.findPrize(matchCount, hasBonusNumber);

            result.merge(prize, 1, Integer::sum);
        }
    }

    private Map<Prize, Integer> initResult() {
        Map<Prize, Integer> result = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
        return result;
    }
}
