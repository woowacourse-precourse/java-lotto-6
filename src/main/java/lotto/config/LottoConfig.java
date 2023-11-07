package lotto.config;

import lotto.controller.LottoController;
import lotto.random.RandomNumberGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public interface LottoConfig {
    LottoController lottoController();
    InputView inputView();
    OutputView outputView();
    LottoService lottoService();
    RandomNumberGenerator randomNumberGenerator();
}