package lotto.game;

import lotto.collaboration.lottos.Lottos;
import lotto.io.lottos.LottosRandoms;

public class LottoGame {

    public void run() {
        Lottos lottos = new Lottos();
        lottos.purchase();

        LottosRandoms lottoNumberAlgorithm = new LottosRandoms();
        lottos.make(lottoNumberAlgorithm);
    }

}
