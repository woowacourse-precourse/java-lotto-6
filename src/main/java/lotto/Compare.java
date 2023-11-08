package lotto;

import java.util.List;

import static lotto.Application.totalWinningAmount;

public class Compare {
    public static void readWinningReturnAmount(Lotto lottoTicket, Lotto lotteryNums, int bonusNum) {
        int winningLotteryNumCnt = 0;
        int winningBonusNumCnt = 0;
        for (Integer lotteryNumber : lotteryNums.getNumbers()) {
            if (lottoTicket.getNumbers().contains(lotteryNumber)) {
                winningLotteryNumCnt++;
            }
        }
        if (lottoTicket.getNumbers().contains(bonusNum)) {
            winningBonusNumCnt++;
        }

        String matchResult = String.valueOf(winningLotteryNumCnt) + String.valueOf(winningBonusNumCnt);

        for (Rank rank : Rank.values()) {
            if (rank.getMatchResult().equals(matchResult)) {
                rank.setCount(rank.getCount() + 1);
                totalWinningAmount += rank.getPrice();
            }
        }
    }
}
