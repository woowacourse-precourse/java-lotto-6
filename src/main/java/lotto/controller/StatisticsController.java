package lotto.controller;

import java.util.HashMap;
import java.util.Map;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningNumber;

public class StatisticsController {
    private final Lottos lottos;
    private final WinningNumber winningNumber;

    private Map<Rank, Integer> rankTable = new HashMap<>();

    public StatisticsController(Lottos lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public void process(){

    }

    public void initStatistics() {
        rankTable.put(Rank.FIFTH, 0);  // 3개 일치
        rankTable.put(Rank.FOURTH, 0); // 4개 일치
        rankTable.put(Rank.THIRD, 0); // 5개 일치
        rankTable.put(Rank.SECOND, 0); // 5개 + 1개 일치
        rankTable.put(Rank.FIRST, 0); // 6개 일치
    }

}
