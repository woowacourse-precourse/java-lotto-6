package lotto.model;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LottoResult {
    private final double payment;
    private Map<LottoPrize, Integer> prizeResult;
    private double totalPrizeMoney;
    private double yieldRate;

    public LottoResult(int payment, WinningLotto winningLotto, List<Lotto> lottos) {
        this.payment = payment;
        this.totalPrizeMoney = 0;
        this.yieldRate = 0;
        this.prizeResult = new EnumMap<LottoPrize, Integer>(LottoPrize.class);
        initPrizeResult();
        calculateWinningResult(winningLotto, lottos);
    }

    public Map<LottoPrize, Integer> getPrizeResult() {
        return prizeResult;
    }

    private void initPrizeResult() {
        for (LottoPrize prize : LottoPrize.values()) {
            this.prizeResult.put(prize, 0);
        }
    }

    private void calculateWinningResult(WinningLotto winningLotto, List<Lotto> lottos) {
        calulatePrizeResult(winningLotto, lottos);
        calculateTotalPrizeMoney();
        calculateYieldRate();
    }

    private void calulatePrizeResult(WinningLotto winningLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.lottoNumbersMatch(lotto);
            boolean matchBonus = winningLotto.lottoBonusNumberMatch(lotto);
            LottoPrize prize = LottoPrize.valueOf(matchCount, matchBonus);
            prizeResult.put(prize, prizeResult.get(prize) + 1);
        }
    }

    private void calculateTotalPrizeMoney() {
        for (LottoPrize prize : LottoPrize.values()) {
            this.totalPrizeMoney += (prizeResult.get(prize) * prize.getPrizeMoney());
        }
    }

    private void calculateYieldRate() {
        final int roundingFactor = 1000;
        final double decimalAdjustment = 10.0;
        this.yieldRate = Math.round(totalPrizeMoney / payment * roundingFactor) / decimalAdjustment;
    }

    private String getYieldRateResult() {
        StringBuilder yieldRateResult = new StringBuilder();
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        yieldRateResult.append("총 수익률은 " + formatter.format(yieldRate) + "%입니다.");
        return yieldRateResult.toString();
    }

    private String getPrizeCountResult(LottoPrize prize) {
        StringBuilder prizeCountResult = new StringBuilder();
        prizeCountResult.append(prize.getPrizeCount() + "개 일치");
        if (prize == LottoPrize.SECOND) {
            prizeCountResult.append(", 보너스 볼 일치");
        }
        return prizeCountResult.toString();
    }

    @Override
    public String toString() {
        StringBuilder winningResult = new StringBuilder();
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize != LottoPrize.ETC) {
                winningResult.append(getPrizeCountResult(prize))
                        .append(" " + prize + " - ")
                        .append(prizeResult.get(prize) + "개\n");
            }
        }
        return winningResult + getYieldRateResult();
    }
}
