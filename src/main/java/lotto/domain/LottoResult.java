package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private Map<Rank, Integer> result;
    public LottoResult(){
        result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void calculate(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottoList) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            result.put(rank, result.get(rank) + 1);
        }
    }

    private int getMatchCount(List<Integer> lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lotto) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

}
