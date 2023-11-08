package lotto.controller;

import lotto.model.Player;
import lotto.model.WinningNumbers;
import lotto.model.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Player player;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        player = new Player();
    }

    public void run() {
        player.buy(inputView.askPurchaseAmount());
        outputView.printPlayerLottoNumbers(player.getLottos());

        WinningNumbers winningNumbers = inputView.askWinningNumbers();

        WinningResult winningResult = player.calculateResult(winningNumbers);
        outputView.printWinningResult(winningResult);
    }
}
