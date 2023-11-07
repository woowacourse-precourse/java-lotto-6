package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private final Map<LottoRank, Integer> lottoRankResult = new LinkedHashMap<>();
    private final int totalPayment;

    public Referee(LottoWinningNumber lottoWinningNumber, List<Lotto> lottos) {
        this.totalPayment = lottos.size() * Lotto.PRICE;
        initializeLottoRankResult();

        for (Lotto lotto : lottos) {
            calculateResult(lottoWinningNumber, lotto);
        }
    }

    private void initializeLottoRankResult() {
        for (LottoRank lottoRankValue : LottoRank.values()) {
            this.lottoRankResult.put(lottoRankValue, 0);
        }
    }

    private void calculateResult(LottoWinningNumber lottoWinningNumber, Lotto lotto) {
        int numberOfMatches = countNumberOfMatches(lottoWinningNumber, lotto);
        boolean bonusNumberMatches = isBonusNumberMatches(lottoWinningNumber, lotto);

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.getNumberMatches() == numberOfMatches) {
                Integer resultCount = lottoRankResult.get(lottoRank);
                lottoRankResult.put(lottoRank, ++resultCount);
            }
        }
    }

    private boolean isBonusNumberMatches(LottoWinningNumber lottoWinningNumber, Lotto lotto) {
        return lotto.getNumbers().contains(lottoWinningNumber.getBonusNumber());
    }

    private static int countNumberOfMatches(LottoWinningNumber lottoWinningNumber, Lotto lotto) {
        int numberOfMatches = 0;
        for (int number : lottoWinningNumber.getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                numberOfMatches++;
            }
        }
        return numberOfMatches;
    }

    public void showResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoRankResult.get(LottoRank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoRankResult.get(LottoRank.FORTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoRankResult.get(LottoRank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoRankResult.get(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoRankResult.get(LottoRank.FIRST) + "개");

        int i = lottoRankResult.get(LottoRank.FIFTH) * LottoRank.FIFTH.price();
        int i2 = lottoRankResult.get(LottoRank.FORTH) * LottoRank.FORTH.price();
        int i3 = lottoRankResult.get(LottoRank.THIRD) * LottoRank.THIRD.price();
        int i4 = lottoRankResult.get(LottoRank.SECOND) * LottoRank.SECOND.price();
        int i5 = lottoRankResult.get(LottoRank.FIRST) * LottoRank.FIRST.price();
        long totalReturn = i + i2 + i3 + i4 + i5;


        float percent = Math.round(((float) totalReturn/totalPayment)*1000) / 10f;

        System.out.println("총 수익률은 " + percent + "%입니다.");

    }
}
