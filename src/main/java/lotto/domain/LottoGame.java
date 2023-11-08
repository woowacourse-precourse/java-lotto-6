package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lotto.enums.Rank;

public class LottoGame {

    private final Map<Rank, Integer> result = new HashMap<>();
    private int totalPrize;
    private double profitRate;

    public LottoGame() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void play(WinningLotto winningLotto, LottoTickets lottoTickets) {
        Lotto winning = winningLotto.getLotto();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            addResult(winning.matchCount(lotto), lotto.contains(bonusNumber));
        }
        totalPrize = calculateTotalPrize();
        profitRate = calculateProfitRate(totalPrize, lottoTickets.getLottoTickets().size());
    }

    private void addResult(int matchCount, boolean isBonus) {
        if (matchCount == 3) {
            result.put(Rank.FIFTH, result.get(Rank.FIFTH) + 1);
        }
        if (matchCount == 4) {
            result.put(Rank.FOURTH, result.get(Rank.FOURTH) + 1);
        }
        if (matchCount == 5) {
            if (isBonus) {
                result.put(Rank.SECOND, result.get(Rank.SECOND) + 1);
            }
            if (!isBonus) {
                result.put(Rank.THIRD, result.get(Rank.THIRD) + 1);
            }
        }
        if (matchCount == 6) {
            result.put(Rank.FIRST, result.get(Rank.FIRST) + 1);
        }
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (Rank rank : result.keySet()) {
            totalPrize += rank.getWinningMoney() * result.get(rank);
        }
        return totalPrize;
    }

    public double calculateProfitRate(int totalPrize, int amount) {
        return Math.round(totalPrize / amount * 1000) * 100.0;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
