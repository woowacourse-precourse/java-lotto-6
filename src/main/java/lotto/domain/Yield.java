package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.constants.Prize;

public class Yield {
    private static final int MULTIPLIER = 100;

    public double calculate(long totalPrizeMoney, long payment) {
        return ((double) totalPrizeMoney / payment) * MULTIPLIER;
    }

    public long sumPrizeMoney(Map<Integer, Integer> winningByRank) {
        Map<Integer, Integer> moneyTable = createMoneyTable();
        for (int rank : winningByRank.keySet()) {
            moneyTable.put(rank, winningByRank.get(rank) * moneyTable.get(rank));
        }
        return sumTableElements(moneyTable);
    }

    private long sumTableElements(Map<Integer, Integer> table) {
        return table.values().stream().mapToLong(Integer::longValue).sum();
    }

    private Map<Integer, Integer> createMoneyTable() {
        Map<Integer, Integer> moneyTable = new HashMap<>();
        moneyTable.put(Prize.FIRST.getRank(), Prize.FIRST.getMoney());
        moneyTable.put(Prize.SECOND.getRank(), Prize.SECOND.getMoney());
        moneyTable.put(Prize.THIRD.getRank(), Prize.THIRD.getMoney());
        moneyTable.put(Prize.FOURTH.getRank(), Prize.FOURTH.getMoney());
        moneyTable.put(Prize.FIFTH.getRank(), Prize.FIFTH.getMoney());
        return moneyTable;
    }
}
