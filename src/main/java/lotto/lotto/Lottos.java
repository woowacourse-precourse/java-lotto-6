package lotto.lotto;

import lotto.game.WinningLottoCounter;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void print() {
        lottos.forEach(Lotto::print);
        System.out.println();
    }

    public void calculateMatchesOfNumber(int bonusNumber,
                                         List<Integer> winningNumber,
                                         WinningLottoCounter winningLottoCounter) {
        int count;
        for (Lotto lotto : lottos) {
            count = lotto.calculateNumberOfMatches(winningNumber);
            incrementCounter(count, lotto, bonusNumber, winningLottoCounter);
        }
    }

    private void incrementCounter(int count,
                                  Lotto lotto,
                                  int bonusNumber,
                                  WinningLottoCounter winningLottoCounter) {
        if (count >= 0 && count <= 2) {
            return;
        }
        if (count != 5) {
            winningLottoCounter.increment(count);
            return;
        }
        boolean check = lotto.containsBonusNumber(bonusNumber);
        if (check) {
            winningLottoCounter.increment(0);
            return;
        }
        winningLottoCounter.increment(5);
    }
}
