package lotto;

import lotto.InputView;

import java.util.List;

import static lotto.OutputView.printTicketCount;
import static lotto.OutputView.printLottoList;
import static lotto.OutputView.printBlankLine;

public class LottoController {

    public void start() {
        Money money = inputLottoMoney();
        int ticketCount = money.getTicketCount();
        printBlankLine();
        printTicketCount(ticketCount);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);
        printBlankLine();

        LottoWin lottoWin = getWinningLotto();
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
}

