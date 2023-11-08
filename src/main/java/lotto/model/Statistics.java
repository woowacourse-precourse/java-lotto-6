package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Statistics {

    private Map<Prize, Integer> result;

    public Statistics(PlayerLottos playerLottos, WinningLotto winningLotto) {
        initResult();
        generateResult(playerLottos, winningLotto);
    }

    public Map<Prize, Integer> getResult() {
        return result;
    }

    private void generateResult(PlayerLottos playerLottos, WinningLotto winningLotto) {
        initResult();

        for (LottoFactory lottoFactory : playerLottos.getLottoPlayerNumbers()) {
            int matchCount = winningLotto.calculateMatchNumber(lottoFactory);
            boolean hasBonusNumber = winningLotto.hasBonusNumber(lottoFactory);
            Prize prize = Prize.findPrize(matchCount, hasBonusNumber);

            result.replace(prize, result.get(prize) + 1);
        }
    }

    private void initResult() {
        Map<Prize, Integer> result = new LinkedHashMap<>();
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
        this.result = result;
    }
}
