package lotto.domain.lotto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.result.WinningRank;
import lotto.domain.result.WinningResult;

public class Lottos {

    public static final int DEFAULT_VALUE = 0;
    public static final int PLUS_VALUE = 1;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResult calculateWinningResult(WinningLotto winningLotto) {
        Map<WinningRank, Integer> winningResult = initWinningResult();
        for (Lotto lotto : lottos) {
            WinningRank winningRank = winningLotto.findWinningRank(lotto);
            winningResult.put(winningRank,
                    winningResult.getOrDefault(winningRank, DEFAULT_VALUE) + PLUS_VALUE);
        }
        return new WinningResult(winningResult);
    }

    private Map<WinningRank, Integer> initWinningResult() {
        Map<WinningRank, Integer> winningResult = new EnumMap<>(WinningRank.class);
        for (WinningRank winningRank : WinningRank.values()) {
            winningResult.put(winningRank, DEFAULT_VALUE);
        }
        return winningResult;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
