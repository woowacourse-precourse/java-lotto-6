package lotto.controller;

import java.util.List;
import lotto.controller.util.handler.InputHandler;
import lotto.model.domain.Lotto;
import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseMoney;
import lotto.model.dto.WinningNumber;
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

        WinningNumber winningNumber = inputHandler.getWinningNumber();

        LottoResult lottoResult = lottoService.findWinningLottos(lottos, winningNumber);
        outputView.printLottoRanks(lottoResult);
        outputView.printEarningRate(lottoResult.getTotalReward(), purchaseMoney.getValue());
    }

}
