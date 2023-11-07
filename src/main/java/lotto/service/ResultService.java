package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoWinningBonusNumber;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.PurchasedLottoNumbers;
import lotto.domain.User;
import lotto.domain.dto.LottoResultDTO;

public class ResultService {

    private final LottoWinningNumbers lottoWinningNumbers;
    private final LottoWinningBonusNumber lottoWinningBonusNumber;

    public ResultService(LottoWinningNumbers lottoWinningNumbers, LottoWinningBonusNumber lottoWinningBonusNumber) {
        this.lottoWinningNumbers = lottoWinningNumbers;
        this.lottoWinningBonusNumber = lottoWinningBonusNumber;
    }

    public Map<LottoRank, Integer> lottoGuess(PurchasedLottoNumbers purchasedLottoNumbers) {
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
        List<Integer> winningNumbers = lottoWinningNumbers.getWinningNumbers();
        int count = 0;
        boolean bonusIsExists = false;
        for (int number : purchasedNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
            if (number == lottoWinningBonusNumber.getWinningBonusNumber()) {
                bonusIsExists = true;
            }
        }
        return LottoRank.of(count, bonusIsExists);
    }

}
