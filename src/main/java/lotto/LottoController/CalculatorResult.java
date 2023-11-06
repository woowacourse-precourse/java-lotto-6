package lotto.LottoController;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorResult {

    public Map<Lotto.LottoRank, Integer> calculateResults(List<Lotto> lottos, Lotto winNumbers, int bonusNumber){
        Map<Lotto.LottoRank, Integer> result = new HashMap<>();
        for(Lotto.LottoRank rank : Lotto.LottoRank.values()){
            result.put(rank,0);
        }
        for(Lotto currntLotto : lottos){
            Lotto.LottoRank rank = currntLotto.determineRank(winNumbers,bonusNumber);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }
}
