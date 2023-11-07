package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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
            int matchCount = 0;
            boolean bonusMatch = false;
            for (int number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                } else if (number == bonusNumber) {
                    bonusMatch = true;
                }
            }
            LottoRank rank = getRank(matchCount, bonusMatch);
            statistics.recordWinningRank(rank);
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
        System.out.println("당첨 통계");
        System.out.println("---");
        // LottoRank 열거형의 값을 역순으로 가져오기 위해 배열을 뒤집습니다.
        LottoRank[] ranks = LottoRank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            LottoRank rank = ranks[i];
            if (rank != LottoRank.NONE) { // NONE은 제외하고 출력
                // 보너스 볼 일치 여부에 따른 문자열 조합
                String bonusMatchString = (rank == LottoRank.SECOND) ? ", 보너스 볼 일치" : "";
                // 숫자에 콤마를 포함시켜 문자열 형식화
                String prizeString = String.format("%,d", rank.getPrize());
                int count = statistics.getCount(rank);
                System.out.println(rank.getMatchCount() + "개 일치" + bonusMatchString + " (" + prizeString + "원) - " + count + "개");
            }
        }
    }



    public void calculateProfitRate(int purchaseAmount) {
        long totalPrize = statistics.getTotalPrize();
        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
