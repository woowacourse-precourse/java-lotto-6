package lotto;

import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.PurchasedLottoTickets;
import lotto.domain.ViewContract;

public class LottoGameRunner {

    private final ViewContract viewContract;
    private final LottoGame lottoGame;

    public LottoGameRunner(ViewContract viewContract, LottoGame lottoGame) {
        this.viewContract = viewContract;
        this.lottoGame = lottoGame;
    }

    public Optional<PurchasedLottoTickets> purchaseLotto() {
        try {
            String purchaseAmount = viewContract.purchaseAmount();
            PurchasedLottoTickets purchasedLottoTickets = lottoGame.purchaseLottoTickets(purchaseAmount)
            viewContract.showPurchaseLottoTickets(purchasedLottoTickets);
            return Optional.of(purchasedLottoTickets);
        } catch (IllegalArgumentException exception) {
            viewContract.showErrorMessage(exception.getMessage());
            return Optional.empty();
        }
    }

    public Optional<Lotto> createWinningLotto() {
        try {

        } catch (IllegalArgumentException exception) {
            return Optional.empty();
        }
    }
}
