package lotto;

import lotto.controller.LottoController;
import lotto.domain.RandomLottoGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.LottoView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoView lottoView = new LottoView(new InputView(), new OutputView());
        LottoService lottoService = new LottoService(new RandomLottoGenerator());
        LottoController lottoController = new LottoController(lottoView, lottoService);

        lottoController.play();
    }
}
