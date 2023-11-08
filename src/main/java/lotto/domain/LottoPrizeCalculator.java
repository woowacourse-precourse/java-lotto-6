package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeCalculator {
    public static void checkLottoResult(LottoReceipt lottoReceipt, WinningLotto winningLotto) {
        List<Lotto> lottoTickets = lottoReceipt.getLottoTickets();
        Map<Rank, Integer> winningStatistics = lottoReceipt.getWinningStatistics();

        for (Lotto l : lottoTickets) {
            // 한 개에 대해 체크
            int matchingCount = compare(l, winningLotto);
            boolean matchBonusNumber = compareBonus(l, winningLotto);
            // 두 변수에 대해 Rank 결정
            Rank rank = checkRank(matchingCount, matchBonusNumber);
            System.out.println(rank);
            winningStatistics.put(rank, winningStatistics.get(rank) + 1);
            System.out.println("결과: "+winningStatistics.get(rank));
        }
    }

    public static void calculateProfitRate(LottoReceipt lottoReceipt, int purchaseAmount) {
        Map<Rank, Integer> winningStatistics = lottoReceipt.getWinningStatistics();

        // (당첨금 - 구매 금액) / 구매 금액
        long profitAmount = 0;
        for (Map.Entry<Rank, Integer> entry : winningStatistics.entrySet()) {
            profitAmount += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        double rate = (profitAmount - purchaseAmount) / purchaseAmount;
        lottoReceipt.setProfitRate(rate);
    }
    public static Rank checkRank(int matchCount, boolean matchBonusNumber) {
        return Rank.from(matchCount, matchBonusNumber);
    }

    public static int compare(Lotto lotto, WinningLotto winningLotto) {
        int matchingCount = 0;
        List<Integer> winningLottoNumber = winningLotto.getWinningLotto().getNumbers();
        for (int n : lotto.getNumbers()) {
            if (winningLottoNumber.contains(n)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    public static boolean compareBonus(Lotto lotto, WinningLotto winningLotto) {
        boolean matchBonusNumber = false;
        int bonusNumber = winningLotto.getBonus();
        if (lotto.getNumbers().contains(bonusNumber)) {
            matchBonusNumber = true;
        }
        return matchBonusNumber;
    }

    public static void calculateProfitRate() {

    }
}
