package lotto.controller;

import lotto.domain.LottoBundle;
import lotto.exception.ExceptionHandler;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final LottoController instance = new LottoController();

    private LottoController() {
    }

    public static LottoController getInstance() {
        return instance;
    }

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final LottoService lottoService = LottoService.getInstance();

    public void run() {
        LottoBundle lottoBundle = ExceptionHandler.handle(this::createLottoBundleFromUserInput);
        outputView.printLottoBundle(lottoBundle);

    }

    private LottoBundle createLottoBundleFromUserInput() {
        int purchasePrice = inputView.readPurchasePrice();
        return lottoService.createLottoBundle(purchasePrice);
    }
}
