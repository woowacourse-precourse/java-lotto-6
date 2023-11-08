package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;

import java.util.List;

public class LottoService {
    private final int[] winningCount;

    public LottoService() {
        winningCount = new int[LottoPrize.values().length];
    }

    public int[] calculateWinningsCounts(LottoTicket lottoTickets, WinningNumbers winningNumbers) {
        List<Integer> winningList = winningNumbers.getWinningNumber();
        int bonusNum = winningNumbers.getBonusNumber();

        for (Lotto lotto : lottoTickets.getLottoList()) {
            int count = lotto.countMatches(winningList);
            boolean hasBonusNum = lotto.contains(bonusNum);
            determineRank(count, hasBonusNum);
        }
        return winningCount;
    }

    private void determineRank(int count, boolean hasBonusNum) {
        if (count == LottoPrize.SECOND.getMatchCount() && hasBonusNum) {
            updatePrizeQuantity(LottoPrize.SECOND, count);
            return;
        }

        for (LottoPrize prize : LottoPrize.values()) {
            updatePrizeQuantity(prize, count);
        }
    }

    private void updatePrizeQuantity(LottoPrize prize, int count) {
        if (count == prize.getMatchCount()) {
            int index = prize.ordinal(); // 열거형 순서를 인덱스로 활용
            winningCount[index]++;
        }
    }


}