package lotto.model;

import java.util.HashMap;
import java.util.List;


public class Lottos {

    private final List<Lotto> lottos ;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public HashMap<Rank,Integer> calculateResult(WinnerLotto winnerLotto){
        HashMap<Rank,Integer> result =  new HashMap<>();
        lottos.stream().map(winnerLotto::compare)
                .forEach(rank -> result.put(rank, result.getOrDefault(rank, 0) + 1));

        return result;
    }
}
