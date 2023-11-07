package lotto;

import java.text.NumberFormat;
import java.util.Map;
import java.util.HashMap;

public class WinningResult {
    private final Map<Rank, Integer> result = new HashMap<>();

    public void addWinningTicket(int matchCount, boolean matchBonus) {
        Rank rank = Rank.valueOf(matchCount, matchBonus);
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public int getCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        NumberFormat numberFormat = NumberFormat.getInstance();
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;
            System.out.println(rank.getCountOfMatch() + "개 일치" + rank.getBonus() +
                    " (" + numberFormat.format(rank.getWinningMoney()) + "원) - " +
                    result.getOrDefault(rank, 0) + "개");
        }
    }

}