package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;
import lotto.dto.ComparatorRequest;


public class LottoCalculator {

    private static final int HUNDRED_PERCENT = 100;
    private static final double HUNDRED_PERCENT_DOUBLE = 100.0;

    public void compareLotto(ComparatorRequest comparatorRequest) {
        WinningLotto winningLotto = comparatorRequest.winningLotto();
        List<Lotto> playerLotto = comparatorRequest.playerNumbers();
        for (Lotto number : playerLotto) {
            int rank = calculateRanking(number, winningLotto);
            if (winningLotto.hasBonusNumber(rank, number)) {
                Ranking.changeCountWhenHasBonusNumber();
            }
            Ranking.increaseRankingCount(rank);
        }
    }

    //Set에 담은 후 Lotto의 숫자 개수(6)만큼 빼면 교집합 -> 로또 숫자 갯수 - 교집합 = 당첨 등수
    private int calculateRanking(Lotto number, WinningLotto winningLotto) {
        Set<Integer> winningNumber = new HashSet<>(winningLotto.numbers().getNumbers());
        winningNumber.addAll(number.getNumbers());
        int count = winningNumber.size() - LottoNumbers.LOTTO_SIZE.getNumber();
        return LottoNumbers.LOTTO_SIZE.getNumber() - count;
    }

    public double calculatePayOff(int purchaseMoney) {
        double payOff = (double) Ranking.getTotalPrizeMoney() / purchaseMoney * HUNDRED_PERCENT;
        return Math.round(payOff * HUNDRED_PERCENT) / HUNDRED_PERCENT_DOUBLE;
    }
}
