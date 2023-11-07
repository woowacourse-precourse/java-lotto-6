package lotto.model;

public class Game {

    private final LottoStore lottoStore;
    private LottoTickets issuedLottoTickets;

    public Game(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public void purchaseLottoTickets(int purchaseAmount) {
        issuedLottoTickets = lottoStore.purchaseRandomLottoTickets(purchaseAmount);
    }
}
