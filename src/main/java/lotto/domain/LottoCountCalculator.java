package lotto.domain;

import lotto.util.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoCountCalculator {

    private final Map<Integer, Integer> lottoResult = new HashMap<>();

    public LottoCountCalculator(List<Lotto> lotto, List<Integer> winLotto, int bonus) {
        initializeLottoResult();
        setLottoResult(lotto, winLotto, bonus);
    }

    private void initializeLottoResult() {
        IntStream.range(Constants.LOTTO_RESULT_INDEX_FIRST, Constants.LOTTO_RESULT_INDEX_LAST).
                forEach(key -> lottoResult.put(key, Constants.INIT_VALUE_ZERO));
    }

    private void setLottoResult(List<Lotto> lotto, List<Integer> winLotto, int bonus) {
        lotto.forEach(ticket -> lottoResultCalculate(countMatches(ticket, winLotto), isBonus(winLotto, bonus)));
    }

    private void lottoResultCalculate(int matches, boolean bonus) {
        if (matches >= Constants.LOTTO_MIN_COUNT) {
            int key = matches;
            if (matches == Constants.LOTTO_BONUS_WINNER_COUNT && bonus) {
                key = Constants.LOTTO_BONUS_WINNER_INDEX;
            }
            lottoResult.put(key, lottoResult.getOrDefault(key, Constants.INIT_VALUE_ZERO) + Constants.COUNT_VALUE_1);
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

    public Map<Integer, Integer> getLottoResult() {
        return lottoResult;
    }
}
