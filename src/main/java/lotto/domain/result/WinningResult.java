package lotto.domain.result;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import lotto.domain.lotto.LottoMoney;

public class WinningResult {

    public static final int MIN_COUNT_INCLUSION = 1;
    private final Map<WinningRank, Integer> winningResult;

    public WinningResult(Map<WinningRank, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public float calculateProfitRate(LottoMoney lottoMoney) {
        float winningMoney = calculateWinningMoney();
        return lottoMoney.calculateProfitRate(winningMoney);
    }

    private float calculateWinningMoney() {
        float result = 0L;
        for (WinningRank winningRank : winningResult.keySet()) {
            if (winningResult.get(winningRank) >= MIN_COUNT_INCLUSION) {
                result += winningRank.getMoney();
            }
        }
        return result;
    }

    public Map<WinningRank, Integer> getResult() {
        return Collections.unmodifiableMap(winningResult);
    }
}
