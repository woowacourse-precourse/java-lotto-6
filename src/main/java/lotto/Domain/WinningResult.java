package lotto.Domain;

import java.util.Map;

public record WinningResult(Map<Rank, Integer> result) {

    public double getIncome() {
        double income = 0d;
        for (Rank rank : result.keySet()) {
            income += (rank.getPrizeMoney() * result.get(rank));
        }
        return income;
    }

}
