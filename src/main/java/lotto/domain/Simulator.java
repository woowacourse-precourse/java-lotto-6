package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Simulator {
    private final Map<LottoRank, Integer> lottoRankResult = new LinkedHashMap<>();
    private float rateOfReturn;

    public Simulator() {
        initializeLottoRankResult();
    }

    public Map<LottoRank, Integer> getLottoRankResult() {
        return this.lottoRankResult;
    }

    public float getRateOfReturn() {
        return this.rateOfReturn;
    }

    private void initializeLottoRankResult() {
        for (LottoRank lottoRankValue : LottoRank.values()) {
            this.lottoRankResult.put(lottoRankValue, 0);
        }
    }

    public void run(LottoWinningNumber lottoWinningNumber, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            calculateRank(lottoWinningNumber, lotto);
        }
        calculateRateOfReturn(lottos);

        showResult();
    }

    private void calculateRank(LottoWinningNumber lottoWinningNumber, Lotto lotto) {
        int numberOfMatches = countNumberOfMatches(lottoWinningNumber, lotto);
        boolean bonusNumberCheck = checkWhenFiveNumberMatches(lottoWinningNumber, lotto, numberOfMatches);

        for (LottoRank lottoRank : LottoRank.values()) {
            if (numberOfMatches == lottoRank.numberMatches() && bonusNumberCheck == lottoRank.bonusNumberCheck()) {
                Integer resultCount = lottoRankResult.get(lottoRank);
                lottoRankResult.put(lottoRank, ++resultCount);
            }
        }
    }

    private int countNumberOfMatches(LottoWinningNumber lottoWinningNumber, Lotto lotto) {
        return (int) lottoWinningNumber.getNumbers().stream()
                .filter(number -> lotto.getNumbers().contains(number))
                .count();
    }

    private boolean checkWhenFiveNumberMatches(LottoWinningNumber lottoWinningNumber, Lotto lotto, int numberOfMatches) {
        return numberOfMatches == LottoRank.SECOND.numberMatches() &&
                isBonusNumberMatches(lottoWinningNumber, lotto);
    }

    private boolean isBonusNumberMatches(LottoWinningNumber lottoWinningNumber, Lotto lotto) {
        return lotto.getNumbers()
                .contains(lottoWinningNumber.getBonusNumber());
    }

    private void calculateRateOfReturn(List<Lotto> lottos) {
        int totalPayment = lottos.size() * Lotto.PRICE;
        long totalReturn = this.lottoRankResult.entrySet().stream()
                .mapToInt(rank -> rank.getKey().price() * rank.getValue())
                .sum();

        final int HUNDRED_PERCENT = 100;
        final int MULTIPLY_NUMBER_FOR_FIRST_PRIME = 10;
        final float DIVISION_NUMBER_FOR_FIRST_PRIME = 10f;
        rateOfReturn = Math.round((float) totalReturn/totalPayment * HUNDRED_PERCENT * MULTIPLY_NUMBER_FOR_FIRST_PRIME)
                        / DIVISION_NUMBER_FOR_FIRST_PRIME;
    }

    private void showResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + this.lottoRankResult.get(LottoRank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + this.lottoRankResult.get(LottoRank.FORTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + this.lottoRankResult.get(LottoRank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + this.lottoRankResult.get(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + this.lottoRankResult.get(LottoRank.FIRST) + "개");
        System.out.println("총 수익률은 " + this.rateOfReturn + "%입니다.");
    }
}
