package lotto;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class WinningResult {
    private final Map<Rank, Integer> result;

    public WinningResult() {
        result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void addResult(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public long getTotalEarnings() {
        long earnings = 0;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            earnings += (long) entry.getKey().getWinningAmount() * entry.getValue();
        }
        return earnings;
    }

    List<Rank> sortedRanks = Arrays.stream(Rank.values())
            .filter(rank -> rank != Rank.MISS)
            .sorted(Comparator.comparing((Rank rank) -> rank.getCountOfMatch())
                    .thenComparing(rank -> rank == Rank.SECOND ? 1 : 0))
            .collect(Collectors.toList());

    DecimalFormat decimalFormat = new DecimalFormat("#,###원");

    public void printResult() {
        for (Rank rank : sortedRanks) {
            if (rank != Rank.MISS) {
                System.out.println(rank.getCountOfMatch() + "개 일치" +
                        (rank == Rank.SECOND ? ", 보너스 볼 일치" : "") +
                        " (" + decimalFormat.format(rank.getWinningAmount()) + ") - " +
                        result.get(rank) + "개");
            }
        }
    }
}
