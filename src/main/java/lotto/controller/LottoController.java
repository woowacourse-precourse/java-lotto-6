package lotto.controller;

import java.util.List;
import lotto.controller.util.handler.InputHandler;
import lotto.model.domain.Lotto;
import lotto.model.dto.BonusNumber;
import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseMoney;
import lotto.model.dto.WinningNumbers;
import lotto.model.service.LottoService;
import lotto.view.output.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputHandler inputHandler, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void startLotto() {
        PurchaseMoney purchaseMoney = inputHandler.getPurchaseMoney();
        List<Lotto> lottos = lottoService.purchaseLotto(purchaseMoney);
        outputView.printLottos(lottos);

        WinningNumbers winningNumbers = inputHandler.getWinningNumbers();
        BonusNumber bonusNumber = inputHandler.getBonusNumber(winningNumbers);

        LottoResult lottoResult = lottoService.findWinningLottos(lottos, winningNumbers, bonusNumber);
        outputView.printLottoRanks(lottoResult);
        outputView.printEarningRate(lottoResult.getTotalReward(), purchaseMoney.getValue());
    }

}
