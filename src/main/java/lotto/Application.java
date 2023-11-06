package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoStore;
import lotto.domain.NumberGenerator.RandomNumberGenerator;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        var lottoPurchaseService = new LottoPurchaseService(LottoStore.from(new RandomNumberGenerator()));
        var lottoController = new LottoController(
            lottoPurchaseService,
            new LottoResultService(),
            new InputView(),
            new OutputView());

        lottoController.run();
    }
}
