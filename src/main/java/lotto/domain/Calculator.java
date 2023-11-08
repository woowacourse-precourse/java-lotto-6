package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public enum Ranking {
        FIRST("6개 일치 (2,000,000,000원) - "),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        THIRD("5개 일치 (1,500,000원) - "),
        FOURTH("4개 일치 (50,000원) - "),
        FIFTH("3개 일치 (5,000원) - ");

        private final String message;

        Ranking(String message) {
            this.message = message;
        }
    }

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

        for (int count : counts){
            if (count == 7){
                FIRST_COUNT++;
            }
            if (count == 6){
                SECOND_COUNT++;
            }
            if (count == 5){
                THIRD_COUNT++;
            }
            if (count == 4){
                FOURTH_COUNT++;
            }
            if (count == 3){
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

    public void printResult(){

    }

    public void rateOfReturn() {

    }
}
