package lotto.domain;

import lotto.util.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoCountCalculator {

    private final Map<Integer, Integer> lottoResult = new HashMap<>();

    public LottoCountCalculator(List<Lotto> lotto, List<Integer> winLotto, int bonus) {
        setLottoResult(lotto, winLotto, bonus);
    }

    public Map<Integer, Integer> getLottoResult() {
        return lottoResult;
    }

    private void setLottoResult(List<Lotto> lotto, List<Integer> winLotto, int bonus) {
        IntStream.range(3, 8).forEach(key -> lottoResult.put(key, 0));
        for (Lotto ticket : lotto) {
            countLotto(countMatches(ticket, winLotto), isBonus(winLotto, bonus));
        }
    }

    private void countLotto(int matches, boolean bonus) {
        if (matches >= Constants.LOTTO_MIN_COUNT) {
            int key = matches;
            if (matches == Constants.LOTTO_BONUS_WINNER_COUNT && bonus) {
                key = Constants.LOTTO_BONUS_WINNER_INDEX;
            }
            lottoResult.put(key, lottoResult.getOrDefault(key, Constants.LOTTO_COUNT_DEFAULT) + Constants.LOTTO_COUNT_SIZE);
        }
    }

    private int countMatches(Lotto ticket, List<Integer> winLotto) {
        return (int) ticket.getNumbers().stream()
                .filter(winLotto::contains)
                .count();
    }

    private boolean isBonus(List<Integer> winLotto, int bonus) {
        return winLotto.contains(bonus);
    }

}
