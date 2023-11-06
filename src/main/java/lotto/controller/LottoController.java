package lotto.controller;

import java.util.List;
import lotto.controller.util.handler.InputHandler;
import lotto.model.domain.Lotto;
import lotto.model.dto.LottoResult;
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
        int money = inputHandler.getMoney();

        List<Lotto> lottos = lottoService.purchaseLotto(money);
        outputView.printLottos(lottos);

        WinningNumber winningNumber = getWinningNumber();

        LottoResult lottoResult = lottoService.findWinningLottos(lottos, winningNumber);
        outputView.printLottoResult(lottoResult, money);
    }

    private WinningNumber getWinningNumber() {
        List<Integer> drawNumbers = inputHandler.getDrawNumbers();
        Integer bonusNumber = inputHandler.getBonusNumber(drawNumbers);

        return new WinningNumber(drawNumbers, bonusNumber);
    }

}
