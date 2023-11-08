package lotto;

import static lotto.Constants.BONUS_BALL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnersCalculator {


    private final LottoNumberComparator lottoNumberComparator;


    public WinnersCalculator(List<Integer> winningNumbers, int bonusNumber) {
        this.lottoNumberComparator = new LottoNumberComparator(winningNumbers, bonusNumber);
    }

    public Map<Integer, Integer> calculateWinners(List<Lotto> lottos) {
        Map<Integer, Integer> winners = new HashMap<>();
        winners.put(3, 0);
        winners.put(4, 0);
        winners.put(5, 0);
        winners.put(5 + BONUS_BALL, 0);
        winners.put(6, 0);
        winners = getCountWinners(lottos, winners);
        return winners;
    }

    private Map<Integer, Integer> getCountWinners(List<Lotto> lottos, Map<Integer, Integer> winners) {
        for (Lotto lotto : lottos) {
            int count = lottoNumberComparator.calculateMatchingNumbers(lotto.getLottoNumbers());
            int countBonus = lottoNumberComparator.calculateMatchingNumberWithBonusNumber(lotto.getLottoNumbers());
            if (count == 5 && countBonus == 1) {
                count = 5 + BONUS_BALL;
            }
            if (winners.containsKey(count)) {
                winners.put(count, winners.get(count) + 1);
            }
        }
        return winners;
    }


}
