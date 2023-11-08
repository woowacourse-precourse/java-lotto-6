package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.from(LottoView.create(), LottoService.create());
        lottoController.start();
    }
}
