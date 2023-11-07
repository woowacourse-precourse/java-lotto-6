package lotto;

import static lotto.view.Prompt.MESSAGE_INPUT_MONEY;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.input.InputView;
import lotto.view.input.LottoMoneyInputView;

public class AppConfig {

    public InputView lottoMoneyInputView() {
        return new LottoMoneyInputView(MESSAGE_INPUT_MONEY);
    }

    public LottoService lottoService() {
        return new LottoService();
    }

    public LottoController lottoController(LottoService lottoService) {
        return new LottoController(lottoService);
    }
}
