package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
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
            winningResult.put(standard, 0);
        }
    }

    private void updateWinningResult(Lottos lottos, WinningLotto winningLotto) {
        List<Lotto> purchasedLottos = lottos.getLottos();
        for (Lotto lotto : purchasedLottos) {
            WinningStandard ranking = WinningStandard.checkMatchNumbers(lotto, winningLotto);
            addResult(ranking, 1);
        }
    }

    private void addResult(WinningStandard standard, int count) {
        winningResult.put(standard, winningResult.get(standard) + count);
    }
}
