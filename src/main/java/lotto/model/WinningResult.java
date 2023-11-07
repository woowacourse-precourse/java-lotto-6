package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private static final int INITIALIZED_COUNT = 0;
    private static final int ADD_COUNT = 1;
    private final Map<WinningStandard, Integer> winningResult = new HashMap<>();

    public WinningResult(Lottos lottos, WinningLotto winningLotto) {
        initialized();
        updateWinningResult(lottos, winningLotto);
    }

    public Map<WinningStandard, Integer> getWinningResult() {
        return winningResult;
    }

    private void initialized() {
        for (WinningStandard standard : WinningStandard.values()) {
            winningResult.put(standard, INITIALIZED_COUNT);
        }
    }

    private void updateWinningResult(Lottos lottos, WinningLotto winningLotto) {
        List<Lotto> purchasedLottos = lottos.getLottos();
        for (Lotto lotto : purchasedLottos) {
            WinningStandard ranking = WinningStandard.getWinningRanking(lotto, winningLotto);
            addResult(ranking);
        }
    }

    private void addResult(WinningStandard standard) {
        winningResult.put(standard, winningResult.get(standard) + ADD_COUNT);
    }
}
