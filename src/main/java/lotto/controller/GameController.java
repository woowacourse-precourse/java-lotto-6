package lotto.controller;

import lotto.domain.Lotto;
import lotto.handler.InputHandler;
import lotto.service.LottoService;
import lotto.view.GameView;

import java.util.List;

public class GameController {
    private final GameView gameView;
    private final InputHandler inputHandler;
    private final LottoService lottoService;

    public GameController(GameView gameView, InputHandler inputHandler, LottoService lottoService) {
        this.gameView = gameView;
        this.inputHandler = inputHandler;
        this.lottoService = lottoService;
    }

    public void startGame() {
        int lottoQuantity = getLottoQuantity();
        List<Lotto> lottos = lottoService.buyLottos(lottoQuantity);

        gameView.showLottos(lottos);

    }

    private int getLottoQuantity() {
        String purchaseAmountInput = gameView.getPurchaseAmountInput();
        return inputHandler.handlePurchaseAmount(purchaseAmountInput);
    }
}
