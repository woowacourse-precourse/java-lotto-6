package lotto.domain;

import static lotto.constants.LottoConfiguration.RATE_DECIMAL_PLACE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.constants.LottoPrize;

public class LottoResult {

    private final List<LottoPrize> lottoResults;
    private final int consumerAmount;
    private final int decimalPlace = RATE_DECIMAL_PLACE.getConfig();
    private int totalPrize;
    private BigDecimal profitRate;
    private int firstPrize;
    private int secondPrize;
    private int thirdPrize;
    private int fourthPrize;
    private int fifthPrize;

    public LottoResult(List<LottoPrize> lottoResults, int consumerAmount) {
        this.lottoResults = lottoResults;
        this.consumerAmount = consumerAmount;
        getLottoWinningResults();
    }

    private void getLottoWinningResults() {
        for (LottoPrize lottoResult : lottoResults) {
            prizeCounting(lottoResult);
            totalPrize += lottoResult.getWinningPrize();
        }
        profitRateCalculation();
    }

    private void prizeCounting(LottoPrize lottoResult) {
        if (lottoResult.equals(LottoPrize.FIRST_PRIZE)) {
            firstPrize++;
        }
        if (lottoResult.equals(LottoPrize.SECOND_PRIZE)) {
            secondPrize++;
        }
        if (lottoResult.equals(LottoPrize.THIRD_PRIZE)) {
            thirdPrize++;
        }
        if (lottoResult.equals(LottoPrize.FOURTH_PRIZE)) {
            fourthPrize++;
        }
        if (lottoResult.equals(LottoPrize.FIFTH_PRIZE)) {
            fifthPrize++;
        }
    }

    private void profitRateCalculation() {
        BigDecimal rate = new BigDecimal(((double) totalPrize / consumerAmount) * 100.0);
        profitRate = rate.setScale(decimalPlace, RoundingMode.HALF_UP);
    }

    public List<Integer> getLottoWinningCounts() {
        return List.of(firstPrize, secondPrize, thirdPrize, fourthPrize, fifthPrize);
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }
}
