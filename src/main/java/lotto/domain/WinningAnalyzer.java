package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningAnalyzer {

    //Key : Rank, Value : 해당 등수인 로또 티켓 갯수
    private final Map<Rank, Integer> winningResult;

    public WinningAnalyzer() {
        winningResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningResult.put(rank, 0);
        }
    }

    public Map<Rank, Integer> compareAllLotto(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            winningResult.put(rank, winningResult.get(rank) + 1);
        }
        return winningResult;
    }

    public double calculateRate(Map<Rank, Integer> result, int inputMoney) {
        int total = 0;
        for (Rank rank : result.keySet()) {
            total += rank.getRewardMoney() * result.get(rank);
        }
        return total / (double) inputMoney * 100;

    }

}
