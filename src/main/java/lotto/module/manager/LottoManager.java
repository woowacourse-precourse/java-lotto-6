package lotto.module.manager;

import lotto.module.domain.PurchaseAmount;
import lotto.module.domain.lotto.Lotto;
import lotto.module.domain.lotto.WinningLotto;
import lotto.module.result.LottoResult;
import lotto.module.result.LottoResultChecker;
import lotto.module.store.LottoStore;

import java.util.List;

public class LottoManager {
    private final LottoConsoleManager lottoConsoleManager;
    private final LottoStore lottoStore;

    public LottoManager(LottoConsoleManager lottoConsoleManager, LottoStore lottoStore) {
        this.lottoConsoleManager = lottoConsoleManager;
        this.lottoStore = lottoStore;
    }

    public static LottoManager of(LottoConsoleManager lottoConsoleManager, LottoStore lottoStore) {
        return new LottoManager(lottoConsoleManager, lottoStore);
    }

    public void run() {
        List<Lotto> purchasedLottoTickets = purchaseLottoTickets();
        WinningLotto winningLottoNumbers = generateWinningNumbers();
        announceResults(purchasedLottoTickets, winningLottoNumbers);
    }

    private List<Lotto> purchaseLottoTickets() {
        PurchaseAmount purchaseAmount = lottoConsoleManager.getPurchaseAmount();
        List<Lotto> purchasedLottoTickets = lottoStore.purchaseLotto(purchaseAmount);
        lottoConsoleManager.printPurchasedLottoTickets(purchasedLottoTickets);
        return purchasedLottoTickets;
    }

    private WinningLotto generateWinningNumbers() {
        return lottoConsoleManager.getWinningLottoNumbers();
    }

    private void announceResults(List<Lotto> purchasedLottoTickets, WinningLotto winningLottoNumbers) {
        LottoResultChecker lottoResultChecker = new LottoResultChecker(LottoResult.newInstance());
        LottoResult result = lottoResultChecker.getResult(purchasedLottoTickets, winningLottoNumbers);
        System.out.println(result.getResult());
    }

}
