package lotto;

import lotto.domain.LottoTickets;
import lotto.view.InputView;

public class GameManager {

    private final InputView inputView;
    private LottoTickets lottoTickets;

    public GameManager(InputView inputView) {
        this.inputView = inputView;
    }

    public void gameStart() {
        publishLottoTickets();

    }

    private void publishLottoTickets() {
        try {
            int purchaseAmount = Integer.parseInt(inputView.readPurchaseAmount());
            lottoTickets = new LottoTickets(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            publishLottoTickets();
        }
    }
}
