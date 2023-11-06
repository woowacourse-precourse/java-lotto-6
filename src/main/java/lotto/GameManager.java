package lotto;

import lotto.domain.LottoTickets;
import lotto.view.InputView;

public class GameManager {

    private final InputView inputView;

    public GameManager(InputView inputView) {
        this.inputView = inputView;
    }

    public void gameStart() {
        LottoTickets lottoTickets = publishLottoTickets();

    }

    private LottoTickets publishLottoTickets() {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(inputView.readPurchaseAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return publishLottoTickets();
        }
        return null;
    }
}
