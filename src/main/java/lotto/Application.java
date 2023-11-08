package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoRank;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.playGame();
    }
}
