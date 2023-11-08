package lotto.controller;

import lotto.domain.money.Money;
import lotto.domain.statistics.LottoRank;
import lotto.domain.statistics.WinningStatistics;
import lotto.domain.ticket.LottoNumberGenerator;
import lotto.domain.ticket.Lottos;
import lotto.domain.winningnumbers.WinningNumbers;
import lotto.view.input.InputConsoleView;
import lotto.view.output.OutputConsoleView;

import java.util.Arrays;
import java.util.List;

public class LottoGameController {

    LottoController lottoController = new LottoController(new LottoNumberGenerator());
    ViewController viewController = new ViewController(new InputConsoleView(),new OutputConsoleView());

    Money money;
    Lottos lottos;
    WinningNumbers winningNumbers;
    WinningStatistics winningStatistics;
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
        this.winningNumbers = new WinningNumbers(winningNumbers,bonusNumber);
    }

    private void setWinningStatistics() {
        this.winningStatistics = new WinningStatistics(money);
        winningStatistics.updateStatistics(lottos.checkLottos(winningNumbers));
    }

    private void printWinningStatistics() {
        viewController.printStatistics(winningStatistics.mapToDto(), LottoRank.mapToDto());
    }


}
