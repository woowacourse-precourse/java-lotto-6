package lotto.service;

import java.util.HashSet;
import java.util.List;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;

public class LottoService {
    public void compareNumbers(WinningLotto winningLotto, HashSet<PurchasedLotto> purchasedLotto) {
        addObserverPurchasedLottoToWinningLotto(purchasedLotto, winningLotto);
        winningLotto.startCompare();
    }

    public WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }


    private void addObserverPurchasedLottoToWinningLotto(HashSet<PurchasedLotto> purchasedLotto,
                                                         WinningLotto winningLotto) {
        for (PurchasedLotto lotto : purchasedLotto) {
            winningLotto.addObserver(lotto); // 옵저버 등록
        }
    }
}
