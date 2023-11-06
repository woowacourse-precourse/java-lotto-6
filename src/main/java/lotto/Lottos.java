package lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void print() {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public int count() {
        return lottos.size();
    }


}
