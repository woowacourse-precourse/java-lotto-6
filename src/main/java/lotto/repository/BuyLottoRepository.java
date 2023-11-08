package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class BuyLottoRepository {

    private final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLotto() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<String> extractAscendingNumbers(){
        return lottos.stream()
                .map(Lotto::listToAscendingString)
                .toList();
    }
}
