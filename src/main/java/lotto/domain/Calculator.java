package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private int FIRST_COUNT = 0;
    private int SECOND_COUNT = 0;
    private int THIRD_COUNT = 0;
    private int FOURTH_COUNT = 0;
    private int FIFTH_COUNT = 0;

    public List<Integer> countCorrectLuckyNumbers(List<Integer> lottoNumbers, List<Integer> luckyNumbers, int bonusNumber) {
        List<Integer> countOfMatch = new ArrayList<>();

        for (int i = 0; i < lottoNumbers.size(); i += 6) {

            List<Integer> batch = lottoNumbers.subList(i, Math.min(i + 6, lottoNumbers.size()));
            int count = (int) batch.stream().filter(luckyNumbers::contains).count();

            if (count == 5 && batch.contains(bonusNumber)) {
                count++;
            } else if (count == 6) {
                count++;
            }
            countOfMatch.add(count);
        }

        return countOfMatch;
    }

    public List<Integer> countRanking(List<Integer> counts) {

        List<Integer> countRanking = new ArrayList<>();

        for (int count : counts) {
            if (count == 7) {
                FIRST_COUNT++;
            }
            if (count == 6) {
                SECOND_COUNT++;
            }
            if (count == 5) {
                THIRD_COUNT++;
            }
            if (count == 4) {
                FOURTH_COUNT++;
            }
            if (count == 3) {
                FIFTH_COUNT++;
            }
        }

        countRanking.add(FIRST_COUNT);
        countRanking.add(SECOND_COUNT);
        countRanking.add(THIRD_COUNT);
        countRanking.add(FOURTH_COUNT);
        countRanking.add(FIFTH_COUNT);

        return countRanking;
    }

    public void printResult(List<Integer> countRanking) {

        Ranking first = Ranking.valueOf("FIRST");
        Ranking second = Ranking.valueOf("SECOND");
        Ranking third = Ranking.valueOf("THIRD");
        Ranking fourth = Ranking.valueOf("FOURTH");
        Ranking fifth = Ranking.valueOf("FIFTH");
        String firstMessage = first.getMessage();
        String secondMessage = second.getMessage();
        String thirdMessage = third.getMessage();
        String fourthMessage = fourth.getMessage();
        String fifthMessage = fifth.getMessage();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(fifthMessage + countRanking.get(4) + "개");
        System.out.println(fourthMessage + countRanking.get(3) + "개");
        System.out.println(thirdMessage + countRanking.get(2) + "개");
        System.out.println(secondMessage + countRanking.get(1) + "개");
        System.out.println(firstMessage + countRanking.get(0) + "개");

    }

    public void rateOfReturn(int inputPurchaseAmount, List<Integer> countRanking) {
        Ranking first = Ranking.valueOf("FIRST");
        Ranking second = Ranking.valueOf("SECOND");
        Ranking third = Ranking.valueOf("THIRD");
        Ranking fourth = Ranking.valueOf("FOURTH");
        Ranking fifth = Ranking.valueOf("FIFTH");
        int firstRankingAmount = first.getRankingAmount() * countRanking.get(0);
        int secondRankingAmount = second.getRankingAmount() * countRanking.get(1);
        int thirdRankingAmount = third.getRankingAmount() * countRanking.get(2);
        int fourthRankingAmount = fourth.getRankingAmount() * countRanking.get(3);
        int fifthRankingAmount = fifth.getRankingAmount() * countRanking.get(4);
        int sum = firstRankingAmount + secondRankingAmount + thirdRankingAmount + fourthRankingAmount + fifthRankingAmount;

        float originRateOfReturn = (float) sum / inputPurchaseAmount * 100;
        float rateOfReturn = (float) Math.round(originRateOfReturn * 100) / 100;
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
