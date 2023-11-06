package domain;

import lotto.Lotto;

import java.math.BigDecimal;
import java.util.List;

public class LottoProfitCalculator {
    private int purchaseAmount;
    private BigDecimal profitRate;
    private BigDecimal prizeAmounts = BigDecimal.ZERO;

    List<Lotto> lottos;

    public LottoProfitCalculator(int purchaseAmount, List<Lotto> lottos) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
        profitCalculator();
    }

    public void rankPrinter() {
        StringBuilder sb = new StringBuilder();

        int[] rankCount = new int[5];
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            if (lotto.getRank() == Lotto.LottoRank.FIFTH) rankCount[0]++;
            if (lotto.getRank() == Lotto.LottoRank.FOURTH) rankCount[1]++;
            if (lotto.getRank() == Lotto.LottoRank.THIRD) rankCount[2]++;
            if (lotto.getRank() == Lotto.LottoRank.SECOND) rankCount[3]++;
            if (lotto.getRank() == Lotto.LottoRank.FIRST) rankCount[4]++;
        }

        sb.append("3개 일치 (5,000원) - " + rankCount[0] + "개").append('\n');
        sb.append("4개 일치 (50,000원) - " + rankCount[1] + "개").append('\n');
        sb.append("5개 일치 (1,500,000원) - " + rankCount[2] + "개").append('\n');
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount[3] + "개").append('\n');
        sb.append("6개 일치 (2,000,000,000원) - " + rankCount[4] + "개").append('\n');

        System.out.println(sb);
    }

    public void profitCalculator() {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            Lotto.LottoRank lottoRank = lotto.getRank();
            String prize = lottoRank.getPrize();

            setPrizeAmounts(prizeAmounts.add(new BigDecimal(prize)));
        }

        setProfitRate(prizeAmounts
                .divide(BigDecimal.valueOf(purchaseAmount))
                .multiply(BigDecimal.valueOf(100))
                .stripTrailingZeros());
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
