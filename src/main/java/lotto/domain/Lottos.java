package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public void purchaseLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
