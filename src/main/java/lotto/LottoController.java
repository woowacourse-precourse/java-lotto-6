package lotto;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputView.inputPurchaseAmount());
        List<Lotto> purchasedLottos = lottoService.purchase(purchaseAmount);
        outputView.printPurchasedLottos(purchasedLottos);

        Lotto winningLotto = new Lotto(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber());
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);

        Result winningResult = lottoService.getWinningResult(purchasedLottos, winningNumber);
        outputView.printWinningResult(winningResult);
    }
}
