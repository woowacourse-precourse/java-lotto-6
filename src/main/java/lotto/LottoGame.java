package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LottoGame {

    private final List<Lotto> lottoTickets;
    private final LottoWinningStatistics statistics;

    public LottoGame(int lottoCount) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoTickets.add(lotto);
        }
        this.statistics = new LottoWinningStatistics();
    }

    public void printLottoTickets() {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void checkWinning(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottoTickets) {
            WinningResult result = calculateWinningResult(lotto, winningNumbers, bonusNumber);
            statistics.recordWinningRank(result.getRank());
        }
    }

    private WinningResult calculateWinningResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
        return new WinningResult(rank);
    }

    private int getMatchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public class WinningResult {
        private final LottoRank rank;

        public WinningResult(LottoRank rank) {
            this.rank = rank;
        }

        public LottoRank getRank() {
            return rank;
        }
    }


    private LottoRank getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return LottoRank.FIRST;
        if (matchCount == 5 && bonusMatch) return LottoRank.SECOND;
        if (matchCount == 5) return LottoRank.THIRD;
        if (matchCount == 4) return LottoRank.FOURTH;
        if (matchCount == 3) return LottoRank.FIFTH;
        return LottoRank.NONE;
    }

    public void printStatistics() {
        printHeader();
        printWinningStatistics();
    }

    private void printHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void printWinningStatistics() {
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE) // NONE 제외
                .sorted(Comparator.reverseOrder()) // 역순 정렬
                .forEach(this::printRankStatistics);
    }

    private void printRankStatistics(LottoRank rank) {
        String bonusMatchString = getBonusMatchString(rank);
        String prizeString = formatPrize(rank.getPrize());
        int count = statistics.getCount(rank);
        System.out.println(
                rank.getMatchCount() + "개 일치" + bonusMatchString + " (" + prizeString + "원) - " + count + "개"
        );
    }

    private String getBonusMatchString(LottoRank rank) {
        return rank == LottoRank.SECOND ? ", 보너스 볼 일치" : "";
    }

    private String formatPrize(long prize) {
        return String.format("%,d", prize);
    }



    public void calculateProfitRate(int purchaseAmount) {
        long totalPrize = statistics.getTotalPrize();
        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
