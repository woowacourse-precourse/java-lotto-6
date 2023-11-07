package lotto.model;

import lotto.constants.Rank;

import java.util.ArrayList;
import java.util.List;

public class GameStatistics {

    public static final Integer LOTTERY_PRICE = 1_000;
    private List<Integer> matchingCounts;
    private List<Rank> lotteryRanks;


    public void generateMatchingCounts() {
        this.matchingCounts = new ArrayList<>();
    }

    public List<Integer> getMatchingCounts() {
        return matchingCounts;
    }

    public List<Rank> getLotteryRanks() {
        return lotteryRanks;
    }

    public void generateLotteryRanks() {
        this.lotteryRanks = new ArrayList<>();
    }

}
