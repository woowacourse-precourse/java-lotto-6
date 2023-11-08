package lotto;

import java.util.List;

public class Compare {
    public static void readWinning(Lotto lottoTicket, List<Integer> lotteryNums, int bonusNum) {
        int winningLotteryNumCnt = 0;
        int winningBonusNumCnt = 0;
        for (Integer lotteryNumber : lotteryNums) {
            if (lottoTicket.getNumbers().contains(lotteryNumber)) {
                winningLotteryNumCnt++;
            }
        }
        if (lottoTicket.getNumbers().contains(bonusNum)) {
            winningBonusNumCnt++;
        }
        String matchResult = String.valueOf(winningLotteryNumCnt) + String.valueOf(winningBonusNumCnt);
        System.out.println(winningLotteryNumCnt + " " + winningBonusNumCnt);
        System.out.println(matchResult);
        for (Rank rank : Rank.values()) {
            if (rank.getMatchResult().equals(matchResult)) {
                rank.setCount(rank.getCount() + 1);
            }
        }
    }
}
