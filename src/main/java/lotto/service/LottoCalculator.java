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
            Ranking.getWinner(rank);
        }
    }

    private int calculateRanking(Lotto number, WinningLotto winningLotto) {
        Set<Integer> winningNumber = new HashSet<>(winningLotto.numbers().getNumbers());
        winningNumber.addAll(number.getNumbers());
        return LottoNumbers.LOTTO_SIZE.getNumber() - winningNumber.size();
    }

    public double calculatePayOff(int purchaseMoney) {
        double payOff = (double) Ranking.getTotalAmount() / purchaseMoney * HUNDRED_PERCENT;
        return Math.round(payOff * HUNDRED_PERCENT) / HUNDRED_PERCENT_DOUBLE;
    }
}
