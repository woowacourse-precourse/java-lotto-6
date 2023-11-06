package lotto;

import lotto.contoller.LottoController;
import lotto.view.LottoView;

public class Application {

    private static final LottoController lottoController = new LottoController(new LottoView());

    public static void main(String[] args) {
        lottoController.startLotto();
    }
}
