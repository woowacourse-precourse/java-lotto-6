package lotto;

import lotto.controller.LottoController;
import lotto.domain.DefualtLottoNumbersGenerator;
import lotto.domain.LottoFactory;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory(new DefualtLottoNumbersGenerator());
        LottoService lottoService = new LottoService(lottoFactory);

        LottoController lottoController = new LottoController(new InputView(), new OutputView(), lottoService);
        lottoController.launch();
    }
}
