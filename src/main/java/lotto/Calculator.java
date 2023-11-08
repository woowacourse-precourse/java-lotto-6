package lotto;

import enums.Prize;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    static final int winnerMatchingCnt = 6;
    static final int second = 5;
    static final int fourth = 4;
    static final int fifth = 3;
    public static void judgeWinner(int matchingCount, HashMap<Prize, Integer> ranking) {
        if (matchingCount == winnerMatchingCnt) {
            ranking.put(Prize.FIRST, ranking.get(Prize.FIRST)+1);
        }
    }

    public static void judgeSecond(int matchingCount, boolean matchingBonus, HashMap<Prize, Integer> ranking) {
        if (matchingCount == second && matchingBonus)
            ranking.put(Prize.SECOND, ranking.get(Prize.SECOND)+1);
    }

    public static void judgeThird(int matchingCount, boolean matchingBonus, HashMap<Prize, Integer> ranking) {
        if (matchingCount == second && !matchingBonus)
            ranking.put(Prize.THIRD, ranking.get(Prize.THIRD)+1);
    }

    public static void judgeFourth(int matchingCount, HashMap<Prize, Integer> ranking) {
        if (matchingCount == fourth)
            ranking.put(Prize.FOURTH, ranking.get(Prize.FOURTH)+1);
    }

    public static void judgeFifth(int matchingCount, HashMap<Prize, Integer> ranking) {
        if (matchingCount == fifth)
            ranking.put(Prize.FIFTH, ranking.get(Prize.FIFTH)+1);
    }

    public static void judgeRanking(int matchingCount, boolean matchingBonus, HashMap<Prize, Integer> ranking) {
        judgeWinner(matchingCount, ranking);
        judgeSecond(matchingCount, matchingBonus, ranking);
        judgeThird(matchingCount, matchingBonus, ranking);
        judgeFourth(matchingCount, ranking);
        judgeFifth(matchingCount, ranking);
    }

    public static float calculateRate(HashMap<Prize, Integer> ranking, int userMoneyAmount) {
        int totalPrize = 0;
        for (Map.Entry<Prize, Integer> rank : ranking.entrySet()) {
            if (rank.getValue() != 0)
                totalPrize += rank.getKey().price * rank.getValue();
        }

        return totalPrize/(float)userMoneyAmount * 100;
    }
}
