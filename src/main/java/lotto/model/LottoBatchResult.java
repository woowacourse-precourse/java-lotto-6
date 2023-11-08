package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoBatchResult {
    private LottoBatch lottoBatch;
    private PrizeNumbers prizeNumbers;
    private List<LottoResult> lottoResults;

    public LottoBatchResult(LottoBatch lottoBatch, PrizeNumbers prizeNumbers) {
        this.lottoBatch = lottoBatch;
        this.prizeNumbers = prizeNumbers;
    }

    public void calculateLottoResults() {
        List<LottoResult> lottoResults = new ArrayList<>();

        lottoBatch.getLottos().forEach(lotto -> {
            lottoResults.add(LottoResult.determinePrize(
                    prizeNumbers.matchedWinningNumberCount(lotto),
                    prizeNumbers.matchedBonusNumber(lotto)));

        });

        Collections.sort(lottoResults, new Comparator<LottoResult>() {
            @Override
            public int compare(LottoResult o1, LottoResult o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });


        this.lottoResults = lottoResults;

    }

    
}
