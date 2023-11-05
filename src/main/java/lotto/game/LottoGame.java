package lotto.game;

import lotto.collaboration.lottos.Lottos;

public class LottoGame {

    public void run() {
        Lottos lottos = new Lottos();
        lottos.purchase();
        lottos.make();
    }

}
