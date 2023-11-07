package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.outputView.LottoOutputView;
import lotto.view.outputView.LottoResultOutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoResultOutputView lottoResultOutputView = new LottoResultOutputView();

        LottoController lottoController = new LottoController(inputView, lottoOutputView,lottoResultOutputView);
        lottoController.run();

    }
}
