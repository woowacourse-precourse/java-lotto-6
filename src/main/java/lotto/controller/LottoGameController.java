package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.domain.money.Money;
import lotto.domain.statistics.LottoRank;
import lotto.domain.statistics.WinningStatistics;
import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.NumberGenerator;
import lotto.domain.winningnumbers.WinningNumbers;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoGameController {

    private final LottoController lottoController;
    private final ViewController viewController;

    private Money money;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private WinningStatistics winningStatistics;

    public LottoGameController(NumberGenerator numberGenerator, InputView inputView, OutputView outputView) {
        this.lottoController = new LottoController(numberGenerator);
        this.viewController = new ViewController(inputView, outputView);
    }

    public void run() {

        buyLottosFromUserInput();
        printLottos();
        setWinningNumbersAndBonusNumber();
        setWinningStatistics();
        printWinningStatistics();
    }

    private void buyLottosFromUserInput() {
        this.money = new Money(Integer.parseInt(viewController.getCost()));
        this.lottos = lottoController.buyLottos(money.getUserMoney());
    }

    private void printLottos() {
        viewController.printLottos(lottoController.transferLottoDtos(lottos));
    }

    private void setWinningNumbersAndBonusNumber() {
        List<Integer> winningNumbers = Arrays.stream(
                        viewController.getWinningNumbers().split(","))
                .map(Integer::parseInt)
                .toList();

        int bonusNumber = Integer.parseInt(viewController.getBonusNumber());
        this.winningNumbers = new WinningNumbers(winningNumbers, bonusNumber);
    }

    private void setWinningStatistics() {
        this.winningStatistics = new WinningStatistics(money);
        winningStatistics.updateStatistics(lottos.checkLottos(winningNumbers));
    }

    private void printWinningStatistics() {
        viewController.printStatistics(winningStatistics.mapToDto(), LottoRank.mapToDto());
    }


}
