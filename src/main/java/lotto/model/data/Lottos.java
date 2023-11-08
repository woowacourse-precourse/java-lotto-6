package lotto.model.data;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void buyLotto(List<Integer> lotto) {
        lottos.add(new Lotto(lotto));
    }

    public List<Lotto> purchasedLotto() {
        return lottos;
    }
}
