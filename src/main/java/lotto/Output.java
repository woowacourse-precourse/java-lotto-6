package lotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class Output {
    Rank rank;
    public void printAmount(int amountOfLotto) {
        System.out.println(amountOfLotto + "개를 구매했습니다.");
    }
    public void printLotto(List<Integer> lottoNumber) {
        List<Integer> numbers = new ArrayList<>(lottoNumber);
        sort(numbers);
        System.out.println(numbers);
    }
    public void printResult(int[] countRankArray) {
        System.out.println("당첨 통계");
        System.out.println("___");
        Rank[] ranks = Rank.values();

        for (int i = 0; i < 5; i++)
            System.out.println(Rank.getResultMessage(ranks[i]) + countRankArray[i] + "개");
    }

    public void printProfit(int[] countRankArray, int amountOfLotto) {
        float profit = 0;
        Rank[] ranks = Rank.values();
        for (int i = 0; i < 5; i++) {
            profit += Rank.getMoney(ranks[i]) * countRankArray[i];
        }
        profit = (profit * 100) / (amountOfLotto * 1000);
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
