package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;
    private LottoTickets lottoTickets;

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        publishLottoTickets();

    }

    private void publishLottoTickets() {
        try {
            int purchaseAmount = Integer.parseInt(inputView.readPurchaseAmount());
            lottoTickets = new LottoTickets(purchaseAmount);
            outputView.printPurchasedLottoTickets(lottoTickets);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            publishLottoTickets();
        }
    }
}
