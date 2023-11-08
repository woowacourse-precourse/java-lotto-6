package lotto;

import java.util.List;

public class Output {
    Rank rank;
    public void printAmount(int amountOfLotto) {
        System.out.println(amountOfLotto + "개를 구매했습니다.");
    }
    public void printLotto(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }
    public void printResult(int[] countRankArray) {
        System.out.println("당첨 통계");
        System.out.println("___");
        Rank[] ranks = Rank.values();

        for (int i = 0; i < 5; i++)
            System.out.println(Rank.getResultMessage(ranks[i]) + countRankArray[i] + "개");
    }
}
