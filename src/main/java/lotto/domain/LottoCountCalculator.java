package lotto.domain;

import lotto.util.Constants;

import java.util.List;
import java.util.Map;

public class LottoCountCalculator {

    private Map<Integer, Integer> lottoResult;

    public LottoCountCalculator(List<Lotto> lotto, List<Integer> winLotto, int bonus) {
        setLottoResult(lotto, winLotto, bonus);
    }

    public Map<Integer, Integer> getLottoResult() {
        return lottoResult;
    }

    public void setLottoResult(List<Lotto> lotto, List<Integer> winLotto, int bonus) {
        for (Lotto ticket : lotto) {
            countLotto(countMatches(ticket, winLotto), isBonus(winLotto, bonus));
        }
    }

    public void countLotto(int matches, boolean bonus) {
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
