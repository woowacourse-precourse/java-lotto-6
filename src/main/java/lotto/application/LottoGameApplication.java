package lotto.application;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class LottoGameApplication {
  public void run() {
    LottoService lottoService = new LottoService(new RandomNumberGenerator());
    InputView inputView = new InputViewImpl();
    OutputView outputView = new OutputViewImpl();
    LottoController lottoController = new LottoController(lottoService, inputView, outputView);
    lottoController.purchase();
  }
}
