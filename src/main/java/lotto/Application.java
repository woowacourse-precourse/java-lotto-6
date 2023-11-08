package lotto;

import lotto.controller.LottoController;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = LottoController.lottoPlayController();
            lottoController.buyLotto();
            lottoController.checkLottoResult();
        } catch (RuntimeException e) {
            OutputView.showErrorMessage(String.valueOf(e));
        }
    }
}