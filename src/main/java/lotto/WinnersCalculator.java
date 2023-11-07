package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinnersCalculator {

    private List<Lotto> lottos;

    private final LottoNumberComparator lottoNumberComparator;

    private Map<Integer, Integer> winners = new HashMap<>();

    public WinnersCalculator(List<Lotto> lottos, List<Integer> winningNumbers) {
        this.lottos = lottos;
        this.lottoNumberComparator = new LottoNumberComparator(winningNumbers);
        winners.put(3, 0);
        winners.put(4, 0);
        winners.put(5, 0);
        winners.put(6, 0);
    }

    public Map<Integer, Integer> calculateWinners() {
        for (Lotto lotto : lottos) {
            int count = lottoNumberComparator.calculateMatchingNumbers(lotto.getLottoNumbers());
            if (count == 3) {
                winners.put(3, winners.get(3) + 1);
            }
            if (count == 4) {
                winners.put(4, winners.get(4) + 1);
            }
            if (count == 5) {
                winners.put(5, winners.get(5) + 1);
            }
            if (count == 6) {
                winners.put(6, winners.get(6) + 1);
            }
        }
        return winners;
    }


}
