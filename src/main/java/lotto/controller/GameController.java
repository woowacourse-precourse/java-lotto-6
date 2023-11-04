package lotto.controller;

import lotto.domain.PurchasePrice;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        PurchasePrice money = inputView.getMoney();
        inputView.getLottoTicket();
    }

}
