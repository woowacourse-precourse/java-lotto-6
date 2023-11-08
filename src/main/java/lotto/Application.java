package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Integer purchaseAmount = inputView.readPurchaseAmount();
        Money money = new Money(purchaseAmount);
        LottoTickets lottoTickets = new LottoTickets(money);

        OutputView outputView = new OutputView();
        outputView.printLottoTickets(lottoTickets.getLottoTickets());

        List<Integer> winnerNumbers = inputView.readWinnerNumbers();
        Lotto winnerLotto = new Lotto(winnerNumbers);
        Integer BonusNumber = inputView.readBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winnerLotto, BonusNumber);
        LottoGame lottoGame = new LottoGame();
        lottoGame.play(winningLotto, lottoTickets);
    }
}
