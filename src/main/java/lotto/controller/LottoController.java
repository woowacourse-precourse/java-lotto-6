package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;
import lotto.io.IoManager;
import lotto.io.OutputView;
import lotto.service.LottoService;

public class LottoController {

    private final IoManager ioManager;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(IoManager ioManager, OutputView outputView, LottoService lottoService) {
        this.ioManager = ioManager;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        purchaseLottos();
        inputWinningLotto();
        resultLottoStatistics();
    }

    private void purchaseLottos() {
        PurchasePrice purchasePrice = ioManager.inputPurchasePrice();
        lottoService.saveLottos(purchasePrice);
        outputView.printLottoResult(lottoService.getPlayerLottoNumbers());
    }

    private void inputWinningLotto() {
        outputView.printWinningNumbers();
        Lotto lotto = ioManager.inputWinningNumbers();

        outputView.printBonusNumber();
        BonusNumber bonusNumber = ioManager.inputBonusNumber(lotto);

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        lottoService.saveWinningLotto(winningLotto);
    }

    private void resultLottoStatistics() {
        outputView.printWinningStatistics();
        lottoService.calculateWinningStatistics();
        lottoService.calculateTotalRate();
        outputView.printLottoStaticsResult(lottoService.getStatistics());
    }
}
