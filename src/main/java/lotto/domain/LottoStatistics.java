package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoResult;

public class LottoStatistics {

    private static final Map<LottoResult, Integer> lottoPlaceResults = new HashMap<>();
    private static final Map<LottoResult, Long> lottoTotalAmountResult = new HashMap<>();

    public LottoStatistics () {
        initLottoPlaceResults();
    }

    private void initLottoPlaceResults() {
        lottoPlaceResults.clear();

        for (LottoResult lottoResult : LottoResult.values()) {
            lottoPlaceResults.put(lottoResult, 0);
        }
    }

    public Map<LottoResult, Integer> calculateLottoResults(List<Lotto> lottos, WinnerNumbers winner) {

        initLottoPlaceResults();
        lottoTotalAmountResult.clear();

        calculateLottoPlaceResult(lottos, winner);
        calculateToTalAmountLottoResults();

        return lottoPlaceResults;
    }

    public double calculateLottoRateOfReturn(int baseBalance) {
        return getTotalAmount() / (double) baseBalance * 100;
    }

    private long getTotalAmount() {
        return lottoTotalAmountResult.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    private void calculateLottoPlaceResult(List<Lotto> lottos, WinnerNumbers winner) {

        for (Lotto lotto : lottos) {

            LottoResult result = getLottoResultByLottoWithWinnerNumber(lotto, winner);

            int count = lottoPlaceResults.get(result);

            lottoPlaceResults.put(result, count + 1);
        }
    }

    private void calculateToTalAmountLottoResults() {

        for (LottoResult result : lottoPlaceResults.keySet()) {
            int count = lottoPlaceResults.get(result);
            long amount = result.calculateLottoAmount(count);

            lottoTotalAmountResult.put(result, amount);
        }
    }


    private LottoResult getLottoResultByLottoWithWinnerNumber(Lotto lotto, WinnerNumbers winner) {

        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winnerNumbers = winner.getNumbers();

        int matchCount = getMatchCount(lottoNumbers, winnerNumbers);

        if (matchCount != LottoResult.THIRD_PLACE.getMatchCount()) {
            return LottoResult.valueOfMatchCount(matchCount);
        }

        int bonusNumber = winner.getBonusNumber();

        if (checkContainBonusNumberInLottoNumbers(lottoNumbers, bonusNumber)) {
            return LottoResult.SECOND_PLACE;
        }

        return LottoResult.THIRD_PLACE;
    }

    private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winnerNumbers) {

        int matchCount = 0;

        for (int number : winnerNumbers) {
            if (lottoNumbers.contains(number)) {
                matchCount += 1;
            }
        }

        return matchCount;
    }

    private boolean checkContainBonusNumberInLottoNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return true;
        }

        return false;
    }

}
