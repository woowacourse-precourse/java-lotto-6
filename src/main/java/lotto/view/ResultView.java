package lotto.view;

import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printNewLine(){
        System.out.println();
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Integer> numbers){
        System.out.println(numbers);
    }

    public static void printResult(Map<Rank, Integer> result) {
        printNewLine();
        System.out.println("당첨 통계");
        System.out.println("---");

        printResultForRank(result, Rank.FIFTH, 5_000);
        printResultForRank(result, Rank.FOURTH, 50_000);
        printResultForRank(result, Rank.THIRD, 1_500_000);
        printResultForRank(result, Rank.SECOND, 30_000_000);
        printResultForRank(result, Rank.FIRST, 2_000_000_000);
    }

    private static void printResultForRank(Map<Rank, Integer> result, Rank rank, int prizeMoney) {
        System.out.println(rank.getMatchCount() + "개 일치" + (rank == Rank.SECOND ? ", 보너스 볼 일치 " : " ")
                + "(" + String.format("%,d", prizeMoney) + "원) - " + result.getOrDefault(rank, 0) + "개");
    }
}
