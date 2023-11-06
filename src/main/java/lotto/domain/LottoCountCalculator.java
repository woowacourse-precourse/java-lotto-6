package lotto.domain;

import lotto.util.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoCountCalculator {

    private final Map<Integer, Integer> CountResult = new HashMap<>();

    public LottoCountCalculator(List<Lotto> myLottoTickets, List<Integer> winLottoNumbers, int bonusNumber) {
        initializeCountResult();
        setCountResult(
                myLottoTickets,
                winLottoNumbers,
                bonusNumber
        );
    }

    private void initializeCountResult() {
        IntStream.range(Constants.LOTTO_RESULT_INDEX_FIRST, Constants.LOTTO_RESULT_INDEX_LAST)
                .forEach(key -> CountResult.put(key, Constants.INIT_VALUE_ZERO));
    }

    private void setCountResult(List<Lotto> myLottoTickets, List<Integer> winLottoNumbers, int bonusNumber) {
        myLottoTickets.forEach(
                myTicket -> saveCountResult(
                        compareNumbers(myTicket, winLottoNumbers),
                        isContainBonus(winLottoNumbers, bonusNumber)
                )
        );
    }

    private void saveCountResult(int numberMatches, boolean isBonusNumber) {
        if (numberMatches >= Constants.LOTTO_MIN_COUNT) {
            int key = numberMatches;
            if (numberMatches == Constants.LOTTO_BONUS_WINNER_COUNT && isBonusNumber) {
                key = Constants.LOTTO_BONUS_WINNER_INDEX;
            }
            CountResult.put(key, CountResult.getOrDefault(key, Constants.INIT_VALUE_ZERO) + Constants.COUNT_VALUE_1);
        }
    }

    private int compareNumbers(Lotto myTicket, List<Integer> winLottoNumbers) {
        return (int) myTicket.getNumbers().stream()
                .filter(winLottoNumbers::contains)
                .count();
    }

    private boolean isContainBonus(List<Integer> winLottoNumbers, int bonusNumber) {
        return winLottoNumbers.contains(bonusNumber);
    }

    public Map<Integer, Integer> getCountResult() {
        return CountResult;
    }
}
