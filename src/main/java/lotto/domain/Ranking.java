package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Ranking {
    FIRST_PRIZE(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND_PRIZE(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PRIZE(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH_PRIZE(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH_PRIZE(3, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");

    private final int countOfMatch;
    private final int prizeMoney;
    private final String message;

    Ranking(int countOfMatch, int prizeMoney, String message){
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static List<Ranking> getValues(){
        List<Ranking> values = new ArrayList<>(Arrays.asList(Ranking.values()));
        Collections.reverse(values);
        values.remove(Ranking.MISS);
        return values;
    }

    public static Ranking valueOf(int countOfMatch, boolean containsBonus){
        if(SECOND_PRIZE.matchCount(countOfMatch) && containsBonus){
            return SECOND_PRIZE;
        }

        for(Ranking ranking : values()){
            if(ranking.matchCount(countOfMatch) && ranking != SECOND_PRIZE){
                return ranking;
            }
        }
        return MISS;
    }

    private boolean matchCount(int countOfMatch){
        return this.countOfMatch == countOfMatch;
    }

    public String getMessage(int count){
        return message + count + "개";
    }

    public int getPrizeMoney(){
        return prizeMoney;
    }

}
