package lotto.constans;

import java.util.Arrays;

public enum WinningGrade {

    FIFTH_PRIZE("3개 일치 (5,000원) - ",3,false,5,5000),
    FOURTH_PRIZE("4개 일치 (50,000원) - ",4,false,4,50000),
    THIRD_PRIZE("5개 일치 (1,500,000원) - ",5,false,3,1500000),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - ",5,true,2,30000000),
    FIRST_PRIZE("6개 일치 (2,000,000,000원) - ",6,false,1,2000000000);

    private final String message;
    private final int matchingCount;
    private final boolean containBonus;
    private final int rank;
    private final int prizeMoney;

    WinningGrade(String message, int matchingCount, boolean containBonus,int rank,int prizeMoney) {
        this.message = message;
        this.matchingCount = matchingCount;
        this.containBonus = containBonus;
        this.rank = rank;
        this.prizeMoney = prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getRank() {
        return rank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static WinningGrade findWinningGrade(int correspond, boolean bonus) {
        return Arrays.stream(WinningGrade.values())
                .filter(grade -> grade.getMatchingCount() == correspond && grade.containBonus == bonus)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}