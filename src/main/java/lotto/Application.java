package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.from(LottoView.create());
        lottoController.start();
    }
}
