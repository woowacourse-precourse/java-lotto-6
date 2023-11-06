package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoResult;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoResult lottoResult = new LottoResult();
        LottoController lottoController = new LottoController(inputView, lottoResult);

        lottoController.play();
    }
}
