package lotto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LottoResult {
    private final Map<Prize, Integer> result = new HashMap<>();

    public LottoResult(Lotto winningLotto, int bonusNumber, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Prize prize = getPrize(winningLotto, bonusNumber, lotto);
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        }
    }

    private Prize getPrize(Lotto winningLotto, int bonusNumber, Lotto lotto) {
        int matchCount = lotto.countMatchNumbers(winningLotto.getNumbers());
        boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);
        if (matchCount == 5 && hasBonusNumber) {
            return Prize.SECOND;
        }
        return Prize.valueOf(matchCount);
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) {
                continue;
            }
            printPrizeResult(prize);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", calculateTotalProfitRate());
    }

    private void printPrizeResult(Prize prize) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        System.out.printf("%d개 일치 (%s원) - %d개%n",
                prize.getMatchCount(),
                decimalFormat.format(prize.getPrizeMoney()),
                getCount(prize));
    }

    private int getCount(Prize prize) {
        return result.getOrDefault(prize, 0);
    }

    private double calculateTotalProfitRate() {
        int totalPrizeMoney = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        int purchaseAmount = result.values().stream().mapToInt(Integer::intValue).sum() * LottoGame.LOTTO_PRICE;
        double profitRate = (double) totalPrizeMoney / purchaseAmount * 100;
        return Math.round(profitRate * 10.0) / 10.0;   // 반올림하여 소수점 둘째 자리까지 표시
    }
}
