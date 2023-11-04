package lotto.controller;

import lotto.domain.LottoPurchasePrice;
import lotto.io.InputManager;
import lotto.io.OutputView;
import lotto.service.LottoService;

public class LottoController {

    private final InputManager inputManager;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputManager inputManager, OutputView outputView, LottoService lottoService) {
        this.inputManager = inputManager;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        purchaseLottos();
    }

    private void purchaseLottos() {
        outputView.printLottoPurchasePriceMessage();
        LottoPurchasePrice lottoPurchasePrice = inputManager.inputLottoPurchasePrice();
        lottoService.saveLottos(lottoPurchasePrice);
        outputView.printLottoResult(lottoService.getLottos());
    }
}
