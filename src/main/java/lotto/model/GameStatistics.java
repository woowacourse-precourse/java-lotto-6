package lotto.model;

import lotto.constants.Rank;

import java.util.ArrayList;
import java.util.List;

public class GameStatistics {

    private List<Integer> matchingCountList;
    private List<Rank> lotteryRankList;

    public static final Integer LOTTERY_PRICE = 1_000;

    public void generateMatchingCountList() {
        this.matchingCountList = new ArrayList<>();
    }

    public List<Integer> getMatchingCountList() {
        return matchingCountList;
    }

    public List<Rank> getLotteryRankList() {
        return lotteryRankList;
    }

    public void generateLotteryRankList() {
        this.lotteryRankList = new ArrayList<>();
    }

}
