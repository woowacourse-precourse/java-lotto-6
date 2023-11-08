package lotto.module.manager;

import lotto.module.console.LottoConsoleManager;
import lotto.module.domain.LottoProfit;
import lotto.module.domain.PurchaseAmount;
import lotto.module.lotto.Lotto;
import lotto.module.lotto.WinningLotto;
import lotto.module.result.LottoResult;
import lotto.module.result.LottoResultManager;
import lotto.module.store.LottoStore;

import java.util.List;

public class LottoManager {
    private final LottoConsoleManager lottoConsoleManager;
    private final LottoResultManager lottoResultManager;
    private final LottoStore lottoStore;

    private LottoManager(LottoConsoleManager lottoConsoleManager, LottoResultManager lottoResultManager, LottoStore lottoStore) {
        this.lottoConsoleManager = lottoConsoleManager;
        this.lottoResultManager = lottoResultManager;
        this.lottoStore = lottoStore;
    }

    public static LottoManager of(LottoConsoleManager lottoConsoleManager, LottoResultManager lottoResultManager, LottoStore lottoStore) {
        return new LottoManager(lottoConsoleManager, lottoResultManager, lottoStore);
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        List<Lotto> purchasedLottoTickets = purchaseLottoTickets(purchaseAmount);
        WinningLotto winningLottoNumbers = generateWinningNumbers();
        announceResults(purchaseAmount, purchasedLottoTickets, winningLottoNumbers);
    }

    private PurchaseAmount getPurchaseAmount() {
        while (true) {
            try {
                return lottoConsoleManager.getPurchaseAmount();
            } catch (IllegalArgumentException e) {
                lottoConsoleManager.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Lotto> purchaseLottoTickets(PurchaseAmount purchaseAmount) {
        while (true) {
            try {
                List<Lotto> purchasedLottoTickets = lottoStore.purchaseLotto(purchaseAmount);
                lottoConsoleManager.printPurchasedLottoTickets(purchasedLottoTickets);
                return purchasedLottoTickets;
            } catch (IllegalArgumentException e) {
                lottoConsoleManager.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningLotto generateWinningNumbers() {
        while (true) {
            try {
                return lottoConsoleManager.getWinningLottoNumbers();
            } catch (IllegalArgumentException e) {
                lottoConsoleManager.printErrorMessage(e.getMessage());
            }
        }
    }

    private void announceResults(PurchaseAmount purchaseAmount, List<Lotto> purchasedLottoTickets, WinningLotto winningLottoNumbers) {
        LottoResult lottoResult = lottoResultManager.calculateResult(purchasedLottoTickets, winningLottoNumbers);
        LottoProfit lottoProfit = lottoResultManager.calculateProfit(purchaseAmount);
        lottoConsoleManager.printLottoWinningResult(lottoResult, lottoProfit);
    }

}
