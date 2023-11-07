package lotto;

import lotto.controller.LottoController;
import lotto.domain.lotto.LottoMachine;
import lotto.service.LottoService;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService(new LottoMachine(), new RandomNumberGenerator());
        
        LottoController lottoController = new LottoController(new InputView(), new OutputView(), lottoService);
        lottoController.run();
    }
}
