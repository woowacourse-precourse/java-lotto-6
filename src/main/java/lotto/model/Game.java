package lotto.model;

import java.util.List;

public class Game {

    private final LottoStore lottoStore;
    private LottoTickets issuedLottoTickets;
    private Lotto winningNumber;

    public Game(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public void purchaseLottoTickets(int purchaseAmount) {
        this.issuedLottoTickets = lottoStore.purchaseRandomLottoTickets(purchaseAmount);
    }

    public void setWinningNumbers(List<Integer> winningNumber) {
        this.winningNumber = new Lotto(winningNumber);
    }
}
