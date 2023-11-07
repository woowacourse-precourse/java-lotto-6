package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoDrawMachine {
    private final PurchaseRepository purchaseRepository = PurchaseRepository.getInstance();
    private WinningLotto winningLotto;

    public LottoDrawMachine(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    private List<Lotto> getPurchasedAllLotto() {
        return purchaseRepository.findLottos();
    }

    public List<LottoRank> findRank() {
        List<LottoRank> ranks = new ArrayList<>();
        Comparator comparator = new Comparator(winningLotto);
        for (Lotto purchasedLotto : getPurchasedAllLotto()) {
            ranks.add(comparator.compareWithWinningLotto(purchasedLotto));
        }
        return ranks;
    }
}
