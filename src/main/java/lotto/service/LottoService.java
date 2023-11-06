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

        Map<LottoResult, Integer> resultStorage = resultStorageInitialize();
        for (Lotto lotto : lottos.getLottos()) {
            int correctCount = checkLotto(lotto, winningLotto.getAnswerLotto());
            boolean hasBonus = checkBonusNumber(lotto, winningLotto.getBonusNumber());
            LottoResult rank = LottoResult.findRank(correctCount, hasBonus);
            if(rank != null) {
                resultStorage.put(rank, resultStorage.getOrDefault(rank, 0) + 1);
            }
        }
        return resultStorage;
    }

    private Map<LottoResult, Integer> resultStorageInitialize() {
        Map<LottoResult, Integer> resultStorage = new HashMap<>();
        for(LottoResult result : LottoResult.values()){
            resultStorage.put(result, 0);
        }
        return resultStorage;
    }

    private boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> myLottoNumbers = lotto.getNumbers();
        return myLottoNumbers.contains(bonusNumber);
    }

    private static int checkLotto(Lotto lotto, Lotto answerLotto) {
        List<Integer> myLottoNumbers = lotto.getNumbers();
        List<Integer> answerLottoNumbers = answerLotto.getNumbers();

        return (int) myLottoNumbers.stream()
                .filter(answerLottoNumbers::contains)
                .count();
    }

    public Lottos generateLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        for (int count = 0; count < lottoCount; count++) {
            Lotto lotto = new Lotto(createRandomNumber());
            lottos.purchaseLotto(lotto);
        }

        return lottos;
    }

    public long sumTotalLottoPrize(Map<LottoResult, Integer> resultStorage) {
        long totalPrize = 0;
        for (LottoResult result : resultStorage.keySet()) {
            totalPrize += calculatePrize(result.getPrize(), resultStorage.get(result));
        }
        return totalPrize;
    }

    private long calculatePrize(int prize, Integer count) {
        return (long) prize * count;
    }
}
