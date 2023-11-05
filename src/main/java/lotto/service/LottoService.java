package lotto.service;

import static lotto.util.LottoGenerator.createRandomNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoService {

    public Map<LottoResult, Integer> getLottoResult(Lottos lottos, WinningLotto winningLotto) {
        Map<LottoResult, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            int correctCount = checkLotto(lotto, winningLotto.getAnswerLotto());
            boolean hasBonus = checkBonus(lotto, winningLotto.getBonusNumber());
            LottoResult rank = LottoResult.findRank(correctCount, hasBonus);

            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
        return lottoResult;
    }

    private boolean checkBonus(Lotto lotto, int bonusNumber) {
        List<Integer> myLottoNumbers = lotto.getNumbers();
        return myLottoNumbers.contains(bonusNumber);
    }

    private static int checkLotto(Lotto lotto, Lotto answerLotto) {
        List<Integer> myLottoNumbers = lotto.getNumbers();
        List<Integer> answerLottoNumbers = answerLotto.getNumbers();
        int equalCount = 0;

        for (int nthIndex = 0; nthIndex < myLottoNumbers.size(); nthIndex++) {
            if (answerLottoNumbers.get(nthIndex) == myLottoNumbers.get(nthIndex)) {
                equalCount++;
            }
        }
        return equalCount;
    }

    public Lottos generateLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        for (int count = 0; count < lottoCount; count++) {
            Lotto lotto = new Lotto(createRandomNumber());
            lottos.purchaseLotto(lotto);
        }

        return lottos;
    }

    public long sumTotalLottoPrize(Map<LottoResult, Integer> lottoResult) {
        long totalPrize = 0;
        for (LottoResult result : lottoResult.keySet()) {
            totalPrize += calculatePrize(result.getPrize(), lottoResult.get(result));
        }
        return totalPrize;
    }

    private long calculatePrize(int prize, Integer count) {
        return (long) prize * count;
    }
}
