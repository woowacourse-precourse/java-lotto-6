package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String purchaseAmount = inputView.readPurchaseAmount();
        Money money = new Money(purchaseAmount);
        LottoTickets lottoTickets = new LottoTickets(money);

        OutputView outputView = new OutputView();
        outputView.printLottoTickets(lottoTickets.getLottoTickets());

        String winnerNumber = inputView.readWinnerNumber();
        String BonusNumber = inputView.readBonusNumber();
    }
}
