package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;
import lotto.domain.dto.Result;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

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

        Result winningResult = lottoService.getWinningResult(purchasedLottos, winningNumber, purchaseAmount);
        outputView.printWinningResult(winningResult);
    }
}
