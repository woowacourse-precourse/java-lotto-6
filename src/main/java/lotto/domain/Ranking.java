package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Ranking {

    MISS(0, 0, false, "0개 일치 - "),
    FIFTH(5_000, 3, false, "3개 일치 (5,000원) - "),
    FOURTH(50_000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1_500_000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원) - ");


    public static final int BONUS_CONTAIN_CONDITION = 5;

    public final int prize;
    public final int matchCount;
    public final boolean bonus;
    public final String message;

    Ranking(int prize, int matchCount, boolean bonus, String message) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.message = message;
    }

    public static Ranking calculate(Lotto lotto, WinningLotto winningLotto) {
        System.out.println(lotto);
        final int matchCount = getMatchCount(lotto, winningLotto.getLotto().getNumbers());
        boolean bonus = false;
        if (matchCount == BONUS_CONTAIN_CONDITION) {
            bonus = lotto.hasMatchedNumber(winningLotto.getBonusNumber());
        }
        //System.out.println("calculate에서 matchCount, bonus : " +matchCount+" " +bonus);
        return getRanking(matchCount, bonus);
    }

    private static int getMatchCount(Lotto lotto, List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (lotto.hasMatchedNumber(number)) {
                count++;
            }
        }
//System.out.println("카운트매치 결과: "+count);
        return count;
    }

    private static Ranking getRanking(int matchCount, boolean bonus) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.matchCount == matchCount && ranking.bonus == bonus) {
                return ranking;
            }
        }
        return MISS;
    }

    public static List<Ranking> getValidRankings() {
        List<Ranking> validRankings = new ArrayList<>();
        for (Ranking ranking : values()) {
            if (ranking != MISS) {
                validRankings.add(ranking);
            }
        }
        return validRankings;
    }

    public static int calculateEarning(List<Ranking> results) {
        int sum = 0;
        for (Ranking ranking : results) {
            sum += ranking.getPrize();
        }
        return sum;
    }

    public int calculateCount(List<Ranking> results) {
        //System.out.println("calculateCount의 result 값"+results);
        int count = 0;
        for (Ranking ranking : results) {
            if (ranking.matchCount == this.matchCount && ranking.bonus == this.bonus) {
                count++;
            }
        }
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
