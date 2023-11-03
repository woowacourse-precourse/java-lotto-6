package lotto;

import java.util.ArrayList;
import java.util.List;

public class GameStatistics {

    private List<Integer> sameNumberCountList;
    private List<Rank> rankList;
    private Integer winningPrizeByRank;
    private Double budgetPrizeRatio;
    private Integer totalPrize;
    public static final Integer BONUS_CONDITION_NUMBER = 5;

    public void generateMatchingNumberCountList() {
        this.sameNumberCountList = new ArrayList<>();
    }

    public List<Integer> getSameNumberCountList() {
        return sameNumberCountList;
    }

    public List<Rank> getRankList() {
        return rankList;
    }

    public void generateRankList() {
        this.rankList = new ArrayList<>();
    }
}
