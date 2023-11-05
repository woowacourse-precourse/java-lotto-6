package lotto;

import lotto.controller.LottoController;
import lotto.domain.Buy;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        lottoController.startLotto();
    }
}
