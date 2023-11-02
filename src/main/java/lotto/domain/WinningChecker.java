package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningChecker {

    final Lottos lottos;
    final List<Integer> winningNumbers;
    final int bonusNumber;

    public WinningChecker(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> countMatchedNumbersEachLotto() {
        return lottos.matchNumbersEachLotto(winningNumbers, bonusNumber);
    }

    public List<Integer> countWinningLottos(List<Integer> matchedNumberCountEachLotto) {
        int rank1 = 0;
        int rank2 = 0;
        int rank3 = 0;
        int rank4 = 0;
        int rank5 = 0;

        List<Integer> rank = new ArrayList<>();
        for (int i : matchedNumberCountEachLotto) {
            if (i == 3) {
                rank5++;
            }
            if (i == 4) {
                rank4++;
            }
            if (i == 5) {
                rank3++;
            }
            if (i == 9) {
                rank2++;
            }
            if (i == 6) {
                rank1++;
            }
        }

        rank.add(rank1);
        rank.add(rank2);
        rank.add(rank3);
        rank.add(rank4);
        rank.add(rank5);

        return rank;
    }
}
