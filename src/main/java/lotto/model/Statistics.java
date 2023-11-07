package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Statistics {

    private Map<Prize, Integer> result;

    public Statistics(LottoPlayerNumbers lottoPlayerNumbers, WinningLotto winningLotto) {
        initResult();
        generateResult(lottoPlayerNumbers, winningLotto);
    }

    public Map<Prize, Integer> getResult() {
        return result;
    }

    private void generateResult(LottoPlayerNumbers lottoPlayerNumbers, WinningLotto winningLotto) {
        initResult();

        for (LottoPlayerNumber lottoPlayerNumber : lottoPlayerNumbers.getLottoPlayerNumbers()) {
            int matchCount = winningLotto.calculateMatchNumber(lottoPlayerNumber);
            boolean hasBonusNumber = winningLotto.hasBonusNumber(lottoPlayerNumber);
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
