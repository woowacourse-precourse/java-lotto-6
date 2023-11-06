package domain;

import lotto.Lotto;
import lotto.LottoRank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoProfitCalculator {
    private int purchaseAmount;
    private BigDecimal profitRate;
    private BigDecimal prizeAmounts = BigDecimal.ZERO;

    List<Lotto> lottos;
    int[] rankCount = new int[5];

    public LottoProfitCalculator(int purchaseAmount, List<Lotto> lottos) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
        profitCalculator();
    }

    public void setRankCount() {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            if (lotto.getRank() == LottoRank.FIFTH) rankCount[0]++;
            if (lotto.getRank() == LottoRank.FOURTH) rankCount[1]++;
            if (lotto.getRank() == LottoRank.THIRD) rankCount[2]++;
            if (lotto.getRank() == LottoRank.SECOND) rankCount[3]++;
            if (lotto.getRank() == LottoRank.FIRST) rankCount[4]++;
        }
    }

    public String rankPrinter() {
        setRankCount();

        StringBuilder sb = new StringBuilder();

        sb.append("3개 일치 (5,000원) - " + rankCount[0] + "개").append('\n');
        sb.append("4개 일치 (50,000원) - " + rankCount[1] + "개").append('\n');
        sb.append("5개 일치 (1,500,000원) - " + rankCount[2] + "개").append('\n');
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount[3] + "개").append('\n');
        sb.append("6개 일치 (2,000,000,000원) - " + rankCount[4] + "개").append('\n');

        return sb.toString();
    }

    public void profitCalculator() {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            LottoRank lottoRank = lotto.getRank();
            String prize = lottoRank.getPrize();

            setPrizeAmounts(prizeAmounts.add(new BigDecimal(prize)));
        }

        setProfitRate(prizeAmounts
                .multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(purchaseAmount), 1, RoundingMode.HALF_UP)
                );
    }

    public String getProfitRate() {
        return profitRate.toString();
    }

    public void setProfitRate(BigDecimal profitRate) {
        this.profitRate = profitRate;
    }

    public void setPrizeAmounts(BigDecimal prizeAmounts) {
        this.prizeAmounts = prizeAmounts;
    }
}
