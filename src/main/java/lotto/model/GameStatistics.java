package lotto.model;

import lotto.constants.Rank;

import java.util.ArrayList;
import java.util.List;

public class GameStatistics {

    private List<Integer> matchingNumberCountList;
    private List<Rank> rankList;

    public static final Integer LOTTERY_PRICE = 1_000;

    public void generateMatchingNumberCountList() {
        this.matchingNumberCountList = new ArrayList<>();
    }

    public List<Integer> getMatchingNumberCountList() {
        return matchingNumberCountList;
    }

    public List<Rank> getRankList() {
        return rankList;
    }

    public void generateRankList() {
        this.rankList = new ArrayList<>();
    }

}
