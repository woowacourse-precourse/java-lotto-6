package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.LottoStore;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoGame = new LottoMachine(new LottoService(new LottoStore()));
        lottoGame.lotto();
    }
}
