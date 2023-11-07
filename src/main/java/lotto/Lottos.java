package lotto;

import java.util.List;
import java.util.ArrayList;

public class Lottos {
    private final List<Lotto> lottos;
    public Lottos() {
        lottos = new ArrayList<>();
    }
    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
