package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
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
            LottoRank lottoRank = compareLottoWinning(lotto);
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        }
        return lottoResult;
    }

    private LottoRank compareLottoWinning(Lotto lotto) {
        List<Integer> purchasedNumbers = lotto.getNumbers();
        boolean bonusIsExists = false;
        int count = countMatchingNumbers(purchasedNumbers);
        if(count == 5)
            bonusIsExists = existsMatchingBonusNumber(purchasedNumbers);
        return LottoRank.of(count, bonusIsExists);
    }

    private int countMatchingNumbers(List<Integer> purchasedNumbers) {
        int count = 0;
        for (int number : purchasedNumbers) {
            if (winningNumbers.getWinningNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean existsMatchingBonusNumber(List<Integer> purchasedNumbers) {
        for (int number : purchasedNumbers) {
            if (number == winningBonusNumber.getWinningBonusNumber()) {
                return true;
            }
        }
        return false;
    }

}
