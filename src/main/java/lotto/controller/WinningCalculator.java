package lotto.controller;

import java.util.List;
import lotto.constant.Ranking;
import lotto.constant.WinningCount;

public class WinningCalculator {
    // 로또의 등수를 매기는 메서드입니다.
    public int rankWinning(List<Integer> lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        int win = countWinning(lotto, winningNumbers);
        if (isSecond(win, lotto, bonusNumber)) {
            return Ranking.SECOND.getRanking();
        }
        return rank(win);
    }

    private int countWinning(List<Integer> lotto, List<Integer> winningNumbers) {
        int win = 0;
        for (Integer number : winningNumbers) {
            if (lotto.contains(number)) {
                win++;
            }
        }
        return win;
    }

    private boolean isSecond(int win, List<Integer> lotto, int bonusNumber) {
        return win == WinningCount.SECOND_WIN.getWinningCount() && lotto.contains(bonusNumber);
    }

    private int rank(int win) {
        if (win == WinningCount.LOTTO_WIN.getWinningCount()) {
            return Ranking.FIRST.getRanking();
        }
        if (win == WinningCount.THIRD_WIN.getWinningCount()) {
            return Ranking.THIRD.getRanking();
        }
        if (win == WinningCount.FOURTH_WIN.getWinningCount()) {
            return Ranking.FOURTH.getRanking();
        }
        if (win == WinningCount.FIFTH_WIN.getWinningCount()) {
            return Ranking.FIFTH.getRanking();
        }
        return Ranking.NOT_WIN.getRanking();
    }
}
