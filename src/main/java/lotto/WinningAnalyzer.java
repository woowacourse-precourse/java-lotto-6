package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningAnalyzer {

    //Key : Rank, Value : 해당 등수인 로또 티켓 갯수
    private final Map<Rank, Integer> winningResult;

    public WinningAnalyzer(){
        winningResult = new HashMap<>();
    }

    public Map<Rank, Integer> compareAllLotto(List<Lotto> lottos, WinningLotto winningLotto){
        for(Lotto lotto : lottos){
            Rank rank = winningLotto.match(lotto);
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
        return winningResult;
    }

}
