package lotto.domain;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LottoResult {
    private final double payment;
    private double totalPrizeMoney;
    private double yieldRate;
    final Map<LottoPrize, Integer> prizeResult;

    public LottoResult(int payment) {
        this.payment = payment;
        this.totalPrizeMoney = 0;
        this.yieldRate = 0;
        this.prizeResult = new EnumMap<LottoPrize, Integer>(LottoPrize.class);
        for (LottoPrize prize : LottoPrize.values()) {
            prizeResult.put(prize, 0);
        }
    }

    public Map<LottoPrize, Integer> getPrizeResult() {
        return prizeResult;
    }

    public void calculateWinningResult(WinningLotto winningLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.lottoNumbersMatch(lotto);
            boolean matchBonus = winningLotto.lottoBonusNumberMatch(lotto);
            LottoPrize prize = LottoPrize.valueOf(matchCount, matchBonus);
            prizeResult.put(prize, prizeResult.get(prize) + 1);
        }
        calculateTotalPrizeMoney();
        calculateYieldRate();
    }

    private void calculateTotalPrizeMoney() {
        for (LottoPrize prize : LottoPrize.values()) {
            this.totalPrizeMoney += (prizeResult.get(prize) * prize.getPrizeMoney());
        }
    }

    private void calculateYieldRate() {
        this.yieldRate = Math.round(totalPrizeMoney / payment * 1000) / 10.0;
    }

    private String getYieldRate() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return "총 수익률은 " + formatter.format(yieldRate) + "%입니다.";
    }

    @Override
    public String toString() {
        StringBuilder winningResult = new StringBuilder();
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize != LottoPrize.ETC) {
                winningResult.append(prize.getPrizeRank() + "개 일치");
                if (prize == LottoPrize.SECOND) {
                    winningResult.append(", 보너스 볼 일치");
                }
                winningResult.append(" " + prize + " - ")
                        .append(prizeResult.get(prize) + "개\n");
            }
        }
        return winningResult + getYieldRate();
    }
}
