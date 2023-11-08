package lotto;

import java.util.List;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.PurchasedLottoStatistics;
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
            String purchaseAmount = viewContract.requestPurchaseAmount();
            PurchasedLottoTickets purchasedLottoTickets = lottoGame.purchaseLottoTickets(purchaseAmount);
            viewContract.showPurchaseLottoTickets(purchasedLottoTickets);
            return Optional.of(purchasedLottoTickets);
        } catch (IllegalArgumentException exception) {
            showErrorMessage(exception.getMessage());
            return Optional.empty();
        }
    }

    public Optional<Lotto> createWinningLotto() {
        try {
            List<Integer> winningNumbers = viewContract.requestWinningLottoNumbers();
            Lotto winningLotto = lottoGame.createWinningLotto(winningNumbers);
            return Optional.of(winningLotto);
        } catch (IllegalArgumentException exception) {
            showErrorMessage(exception.getMessage());
            return Optional.empty();
        }
    }

    public Optional<PurchasedLottoStatistics> createPurchasedLottoStatistics(
            PurchasedLottoTickets purchasedLottoTickets,
            Lotto winningLotto
    ) {
        try {
            int bonusNumber = viewContract.requestBonusNumber();
            PurchasedLottoStatistics statistics = lottoGame.createStatistics(purchasedLottoTickets, winningLotto,
                    bonusNumber);
            viewContract.showStatistics(statistics);
            return Optional.of(statistics);
        } catch (IllegalArgumentException exception) {
            showErrorMessage(exception.getMessage());
            return Optional.empty();
        }
    }

    private void showErrorMessage(String message) {
        viewContract.showErrorMessage(message);
    }
}
