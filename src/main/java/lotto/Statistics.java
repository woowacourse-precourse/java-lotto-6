package lotto;

import java.security.interfaces.RSAKey;
import java.util.List;

public class Statistics {

    private final List<List<Integer>> lottoNumbers;
    private final List<Integer> winningNumbers;
    private final Integer bonus;

    int matchingBonus = 0;

    public Statistics(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers, Integer bonus) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public void compareNumber() {
        for (List<Integer> lottoNumber : lottoNumbers) {
            int matchingCount = 0;
            for (Integer number : lottoNumber) {
                matchingCount = getMatchingCount(number, matchingCount);
            }
            countMatch(matchingCount, matchingBonus);
        }
        printResult();
    }

    private int getMatchingCount(Integer number, int matchingCount) {
        if (number == bonus) {
            matchingBonus++;
            return matchingCount;
        }

        for (Integer winningNumber : winningNumbers) {
            if (number == winningNumber) {
                matchingCount++;
                break;
            }
        }

        return matchingCount;
    }

    public void countMatch(int matchingCount, int matchingBonus) {
        if (matchingCount == 3) {
            Result.THREE.setMatch(Result.THREE.getMatch() + 1);
        }

        if (matchingCount == 4) {
            Result.FOUR.setMatch(Result.FOUR.getMatch() + 1);
        }

        if (matchingCount == 5 && matchingBonus == 0) {
            Result.FIVE.setMatch(Result.FIVE.getMatch() + 1);
        }

        if (matchingCount == 5 && matchingBonus == 1) {
            Result.BONUS.setMatch(Result.BONUS.getMatch() + 1);
        }

        if (matchingCount == 6) {
            Result.SIX.setMatch(Result.SIX.getMatch() + 1);
        }
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        double revenue = 0;
        for (Result result : Result.values()) {
            System.out.println(result.getResult() + " - " + result.getMatch() + "개");
            revenue += result.getMatch() * result.getMoney();
        }

        double revenuePercent = revenue / (lottoNumbers.size() * 1000) * 100;

        System.out.println("총 수익률은 " + Math.round(revenuePercent * 100) / 100.0 + "%입니다.");
    }
}
