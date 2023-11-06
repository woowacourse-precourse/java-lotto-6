package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
