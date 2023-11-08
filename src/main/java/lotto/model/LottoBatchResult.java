package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoBatchResult {
    private LottoBatch lottoBatch;
    private PrizeNumbers prizeNumbers;
    private List<LottoResult> lottoResults=new ArrayList<>();

    public LottoBatchResult(LottoBatch lottoBatch, PrizeNumbers prizeNumbers) {
        this.lottoBatch = lottoBatch;
        this.prizeNumbers = prizeNumbers;
    }

    public void calculateLottoResults() {

        lottoBatch.getLottos().forEach(lotto -> {
            lottoResults.add(LottoResult.determinePrize(
                    prizeNumbers.matchedWinningNumberCount(lotto),
                    prizeNumbers.matchedBonusNumber(lotto)));
        });

        LottoResult.sort(lottoResults);

    }


    public Float calculateLottoProfitRate(Integer purchaseAmount) {
        Integer prizeMoney = 0;
        for (LottoResult lottoResult : lottoResults) {
            prizeMoney += lottoResult.getPrizeMoney();
        }

        return (prizeMoney.floatValue() / purchaseAmount.floatValue()) * 100;
    }

    public List<LottoResult> getValue() {
        return lottoResults;
    }
}