package lotto.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import lotto.constants.Prize;

public class Yield {
    public double calculate(long totalPrizeMoney, long payment) {
        return ((double) totalPrizeMoney / payment) * 100;
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
        moneyTable.put(1, Prize.FIRST.getMoney());
        moneyTable.put(2, Prize.SECOND.getMoney());
        moneyTable.put(3, Prize.THIRD.getMoney());
        moneyTable.put(4, Prize.FOURTH.getMoney());
        moneyTable.put(5, Prize.FIFTH.getMoney());
        return moneyTable;
    }
}
