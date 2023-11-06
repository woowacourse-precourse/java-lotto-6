package lotto;

import java.util.HashMap;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public HashMap<Rank, Integer> getWinningResult(LottoChecker lottoChecker) {
        HashMap<Rank, Integer> winningResult = new HashMap<>();
        for (Lotto lotto : this.lottos) {
            Rank rank = lottoChecker.getRankByLotto(lotto);

            winningResult.putIfAbsent(rank, 1);
            winningResult.put(rank, winningResult.get(rank) + 1);
        }
        return winningResult;
    }

}
