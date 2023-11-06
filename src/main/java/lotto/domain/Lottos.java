package lotto.domain;

import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public void match(List<Integer> luckyNumbers, int bonusNumber){
        for (Lotto lotto : lottos) {
            Map<String, Integer> result = lotto.match(luckyNumbers, bonusNumber);
        }
    }
}
