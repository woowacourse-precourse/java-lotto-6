package lotto;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<LottoRank, Integer> ranksCount = new EnumMap<>(LottoRank.class);

    public LottoResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        for (LottoRank rank : LottoRank.values()) {
            ranksCount.put(rank, 0);
        }
    }

    public void addLottoResult(Lotto lotto) {
        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber) && matchCount == 5;
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
        ranksCount.put(rank, ranksCount.get(rank) + 1);
    }

    public void printStatistics(int lottoCount) {
        long totalPrizeMoney = 0;
        System.out.println("\n당첨 통계\n---");

        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() < 3) {
                continue;
            }
            int count = ranksCount.get(rank);
            String bonusText = rank == LottoRank.SECOND ? ", 보너스 볼 일치" : "";
            System.out.printf("%d개 일치%s (%s원) - %d개\n",
                    rank.getMatchCount(),
                    bonusText,
                    new DecimalFormat("#,###").format(rank.getPrizeMoney()),
                    count);
            totalPrizeMoney += (long) count * rank.getPrizeMoney();
        }

        double profitRate = (double) totalPrizeMoney / (lottoCount * 1000) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
