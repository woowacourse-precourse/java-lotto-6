package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoModel;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    private static final LottoOutputView lottoOutputView = new LottoOutputView();
    private static final LottoInputView lottoInputView = new LottoInputView();
    private static final LottoModel lottoModel = new LottoModel();
    private static final LottoController lottoController = new LottoController(lottoInputView, lottoOutputView, lottoModel);

    public static void main(String[] args) {
        lottoController.startGame();
    }
}
