package lotto;

import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
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
        Integer BonusNumber = inputView.readBonusNumber();
    }
}
