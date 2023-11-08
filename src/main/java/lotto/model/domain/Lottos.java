package lotto.model.domain;

import java.util.ArrayList;

public class Lottos {

    final private ArrayList<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public ArrayList<Lotto> getLottos() {
        return lottos;
    }

    public void addNewLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
