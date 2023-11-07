package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int LOTTO_PRICE = 1000;
    private Map<Rank, Integer> result;
    public LottoResult(){
        result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void calculate(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottoList) {
            int matchCount = LottoCalculate.getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean matchBonus = LottoCalculate.checkMatchBonus(lotto.getNumbers(), bonusNumber);
            Rank rank = LottoCalculate.checkValue(matchCount, matchBonus);
            updateResult(rank);
        }
    }

    private void updateResult(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public double profitRate(int amount) {
        double totalProfit = 0;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            totalProfit += entry.getKey().getWinningMoney() * entry.getValue();
        }
        return totalProfit / (amount * LOTTO_PRICE) * 100;
    }
}
