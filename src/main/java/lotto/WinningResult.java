package lotto;

import java.util.Map;
import java.util.HashMap;

public class WinningResult {
    private final Map<Rank, Integer> result = new HashMap<>();

    public void addWinningTicket(int matchCount, boolean matchBonus) {
        Rank rank = Rank.valueOf(matchCount, matchBonus);
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;
            System.out.println(rank.getCountOfMatch() + "개 일치" + rank.getBonus() +
                    "(" + rank.getWinningMoney() + "원)- " +
                    result.getOrDefault(rank, 0) + "개");
        }
    }
}
