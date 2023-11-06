package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    public void buy(int money) {
        while (money >= 1000) {
            money -= 1000;
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
        }
    }
}