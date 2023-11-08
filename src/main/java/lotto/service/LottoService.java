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

    public int[] calculateWinningsCounts(WinningNumbers winningNumbers, List<Lotto> lottoList) {
        List<Integer> winningList = winningNumbers.getWinningNumbers();
        int bonusNum = winningNumbers.getBonusNumber();

        for (Lotto lotto : lottoList) {
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

    public double calculateProfitRatio(LottoTicket lottoTicket) {
        // 사용자의 지불 금액과 총 당첨 금액을 바탕으로 수익률을 계산합니다.
        int purchaseAmount = lottoTicket.getPurchaseAmount();
        long totalPrize = getTotalLottoPrize();
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    private long getTotalLottoPrize() {
        long result = 0;
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            result += (long) lottoPrize.getPrize() * winningCount[lottoPrize.ordinal()];
        }
        return result;
    }
}