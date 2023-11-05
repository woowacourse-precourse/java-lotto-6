package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.GameConfig;

public class WinningResult {

    private final Map<LottoRank, Integer> winningResult = new HashMap<>();

    public void addLottoRank(LottoRank lottoRank) {
        int winningResultValue = getWinningResultValue(lottoRank);
        winningResult.put(lottoRank, ++winningResultValue);
    }

    private int getWinningResultValue(LottoRank lottoRank) {
        return winningResult.getOrDefault(lottoRank, GameConfig.ZERO.getValue());
    }
}
