package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoBuyer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public static LottoController lottoController () {
        return new LottoController(lottoBuyer(),inputView(),outputView());
    }

    private static LottoBuyer lottoBuyer() {
        return new LottoBuyer();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
