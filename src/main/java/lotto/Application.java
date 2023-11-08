package lotto;

import lotto.controller.LottoGame;
import lotto.service.LottoGameServiceImpl;
import lotto.service.LottoGameService;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(lottoGameService());
        lottoGame.start();
    }

    public static LottoGameService lottoGameService() {
        return new LottoGameServiceImpl();
    }
}
