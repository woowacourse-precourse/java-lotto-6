package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.Lottos;

public class Purchases {
    private List<Lotto> lottos = new ArrayList<>();

    public void recordPurchase(Lotto lotto) {
        lottos.add(lotto);
    }

    public Integer size() {
        return lottos.size();
    }

    public Lottos findLottos() {
        return new Lottos(lottos);
    }

}
