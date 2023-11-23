package lotto;

import lotto.domain.lotto.LottoService;
import lotto.domain.lotto.entity.Lottos;
import lotto.domain.lotto.generator.RandomLottoGenerator;
import lotto.exception.RetryExceptionHandler;
import lotto.view.InputView;
import lotto.view.io.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RetryExceptionHandler handler = new RetryExceptionHandler();
    private final LottoService lottoService = new LottoService(new RandomLottoGenerator());

    void run() {
        Lottos lottos = purchaseLotto();
        printPurchasedLotto(lottos);
    }

    private Lottos purchaseLotto() {
        return handler.get(() -> {
            int purchaseMoney = inputView.getPurchaseMoney();
            return lottoService.purchaseLottos(purchaseMoney);
        });
    }

    private void printPurchasedLotto(Lottos lottos) {
        outputView.printPurchasedLotto(lottos);
    }
}
