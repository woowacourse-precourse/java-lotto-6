package lotto.controller;

import lotto.view.InputView;
import lotto.domain.*;

import java.util.List;

import static lotto.view.OutputView.printTicketCount;
import static lotto.view.OutputView.printLottoList;
import static lotto.view.OutputView.printStatistics;

public class LottoController {
    public void start() {
        Money money = inputLottoMoney();
        int ticketCount = money.getTicketCount();
        printTicketCount(ticketCount);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);

        LottoWin lottoWin = getWinningLotto();
        Prize prize = new Prize();
        calculateResult(prize, lottoWin, lottos);

        ProfitRate profitRate = getRate(money, prize);
        printStatistics(prize, profitRate);
    }

    private Money inputLottoMoney() {
        int ticket = InputView.inputRequestMoney();
        return new Money(ticket);
    }

    private Lottos getLottos(Money money) {
        GenerateLotto generateLotto = new GenerateLotto();
        return new Lottos(generateLotto.lottoGroup((money.getTicketCount())));
    }

    private LottoWin getWinningLotto() {
        List<Integer> winningNumbers = InputView.getWinningNumber();
        Integer bonusNumber = InputView.getBonusNumber();

        return new LottoWin(winningNumbers, bonusNumber);
    }

    private void calculateResult(Prize prize, LottoWin lottoWin, Lottos lottos) {
        prize.calculatePrize(lottoWin, lottos);
    }

    private ProfitRate getRate(Money money, Prize prize) {
        return new ProfitRate(money, prize);
    }
}

