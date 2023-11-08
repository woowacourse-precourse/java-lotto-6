package lotto.controller;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.PurchasePrice;
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
        resultLottoGame();
    }

    private void purchaseLottos() {
        PurchasePrice purchasePrice = ioManager.inputPurchasePrice();
        lottoService.saveLottos(purchasePrice);
        outputView.printPlayerLottoResultMessage(lottoService.getPlayerLottoNumbers());
    }

    private void inputWinningLotto() {
        Lotto lotto = ioManager.inputLotto();
        BonusNumber bonusNumber = ioManager.inputBonusNumber(lotto);
        lottoService.saveWinningLotto(lotto, bonusNumber);
    }

    private void resultLottoGame() {
        outputView.printWinningStatisticsMessage();
        lottoService.calculateWinningStatistics();
        lottoService.calculateTotalRate();
        outputView.printGameResultMessage(lottoService.getGameResult());
    }
}
