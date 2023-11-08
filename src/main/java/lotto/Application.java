package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Money money = new Money(inputView.readPurchaseAmount());
        LottoTickets lottoTickets = new LottoTickets(money);

        OutputView outputView = new OutputView();
        outputView.printLottoTickets(lottoTickets.getLottoTickets());

        Lotto winnerLotto = new Lotto(inputView.readWinnerNumbers());
        WinningLotto winningLotto = new WinningLotto(winnerLotto, inputView.readBonusNumber());

        LottoGame lottoGame = new LottoGame();
        lottoGame.play(winningLotto, lottoTickets);

        outputView.printStatistics(lottoGame.getResults());
        outputView.printProfitRate(lottoGame.calculateProfitRate(money.getAmount()));
    }
}
