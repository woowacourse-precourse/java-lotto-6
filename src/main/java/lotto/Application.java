package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoView;

public class Application {

    public static void main(String[] args) {
        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoView);
        lottoController.run();
    }
}
