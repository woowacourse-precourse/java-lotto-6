package lotto.domain.lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.result.WinningRank;
import lotto.domain.result.WinningResult;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResult calculateWinningResult(WinningLotto winningLotto) {
        Map<WinningRank, Integer> winningResult = new EnumMap<>(WinningRank.class);
        for (Lotto lotto : lottos) {
            WinningRank winningRank = winningLotto.findWinningRank(lotto);
            winningResult.put(winningRank, winningResult.getOrDefault(winningRank,0) + 1);
        }
        return new WinningResult(winningResult);
    }
}
