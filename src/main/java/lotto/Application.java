package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoView);
        lottoController.testRun();
    }
}
