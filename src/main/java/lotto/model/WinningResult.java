package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.GameConfig;
import lotto.view.OutputView;

public class WinningResult {

    private final Map<LottoRank, Integer> winningResult = new HashMap<>();

    public WinningResult() {
        initWinningResult();
    }

    public void addLottoRank(LottoRank lottoRank) {
        int winningResultValue = getWinningResultValue(lottoRank);
        winningResult.put(lottoRank, ++winningResultValue);
    }

    public void displayWinningResult() {
        for (LottoRank lottoRank : winningResult.keySet()) {
            OutputView.printLottoRank(lottoRank, getWinningResultValue(lottoRank));
        }
    }

    private void initWinningResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            winningResult.put(lottoRank, GameConfig.ZERO.getValue());
        }
    }

    private int getWinningResultValue(LottoRank lottoRank) {
        return winningResult.getOrDefault(lottoRank, GameConfig.ZERO.getValue());
    }
}
