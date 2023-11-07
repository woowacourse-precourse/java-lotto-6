package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningBonusNumber;
import lotto.domain.WinningNumbers;
import lotto.domain.PurchasedLotto;

public class ResultService {

    private final WinningNumbers winningNumbers;
    private final WinningBonusNumber winningBonusNumber;

    public ResultService(WinningNumbers winningNumbers, WinningBonusNumber winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.winningBonusNumber = winningBonusNumber;
    }

    public Map<LottoRank, Integer> lottoGuess(PurchasedLotto purchasedLottoNumbers) {
        List<Lotto> purchasedLotto = purchasedLottoNumbers.getPurchasedLotto();
        Map<LottoRank, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : purchasedLotto) {
            List<Integer> purchasedNumbers = lotto.getNumbers();
            LottoRank lottoRank = compareLottoWinning(purchasedNumbers);
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        }
        return lottoResult;
    }

    private LottoRank compareLottoWinning(List<Integer> purchasedNumbers) {
        List<Integer> winningNumbers = this.winningNumbers.getWinningNumbers();
        int count = 0;
        boolean bonusIsExists = false;
        for (int number : purchasedNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
            if (number == winningBonusNumber.getWinningBonusNumber()) {
                bonusIsExists = true;
            }
        }
        return LottoRank.of(count, bonusIsExists);
    }

}
