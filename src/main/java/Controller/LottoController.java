package Controller;

import View.InputView;
import View.OutputView;
import lotto.Calculator;
import lotto.Player;
import lotto.WinningNumbers;
import lotto.WinningStatistics;

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
        outputView.printUserLottoNumbers(player.getLottos());

        WinningNumbers winningNumbers = inputView.askWinningNumbers();

        Calculator calculator = new Calculator(player.getLottos(), winningNumbers);
        WinningStatistics winningStatistics = calculator.calculateStatistics(player.getMoney());
        outputView.printStatistics(winningStatistics);
    }
}
