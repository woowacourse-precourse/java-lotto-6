package lotto.domain;

import java.util.List;

public class WinningResult {
    private final int FIRST_RANKING_INDEX = 0;
    private final int SECOND_RANKING_INDEX = 1;
    private final int THIRD_RANKING_INDEX = 2;
    private final int FOURTH_RANKING_INDEX = 3;
    private final int FIFTH_RANKING_INDEX = 4;

    private final int FirstPlaceCount;
    private final int SecondPlaceCount;
    private final int ThirdPlaceCount;
    private final int FourthPlaceCount;
    private final int FifthPlaceCount;

    public WinningResult(List<Integer> totalRankingCount) {
        this.FirstPlaceCount = totalRankingCount.get(FIRST_RANKING_INDEX);
        this.SecondPlaceCount = totalRankingCount.get(SECOND_RANKING_INDEX);
        this.ThirdPlaceCount = totalRankingCount.get(THIRD_RANKING_INDEX);
        this.FourthPlaceCount = totalRankingCount.get(FOURTH_RANKING_INDEX);
        this.FifthPlaceCount = totalRankingCount.get(FIFTH_RANKING_INDEX);
    }

    public int getFirstPlaceCount() {
        return FirstPlaceCount;
    }

    public int getSecondPlaceCount() {
        return SecondPlaceCount;
    }

    public int getThirdPlaceCount() {
        return ThirdPlaceCount;
    }

    public int getFourthPlaceCount() {
        return FourthPlaceCount;
    }

    public int getFifthPlaceCount() {
        return FifthPlaceCount;
    }

}
