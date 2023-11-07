package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.Lotto;
import lotto.WinnerRating;

public class WinnerJudgementer {

    public static void judgeWinners(List<Lotto> lottos, Lotto winnerLotto, int bonusNumber,
                                    Map<WinnerRating, Integer> winners) {
        Set<Integer> winnerLottoNumbers = new HashSet<>();
        winnerLotto.setWinnerLottoNumbers(winnerLottoNumbers);
        for (Lotto lotto : lottos) {
            WinnerRating winnerRating = lotto.judgeWinner(winnerLottoNumbers, bonusNumber);
            winners.put(winnerRating, winners.getOrDefault(winnerRating, 0) + 1);
        }
    }
}
