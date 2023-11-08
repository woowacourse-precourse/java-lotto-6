package lotto.view;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLotto(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i< numbers.size();i++) {
            sb.append(numbers.get(i)).append(", ");
        }
        sb.deleteCharAt(sb.length()-2);
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");

        System.out.println(sb);
    }

    public static void printResult(HashMap<Rank, Integer> resultMap) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Rank.FIFTH.getMessage() + resultMap.get(Rank.FIFTH) + "개");
        System.out.println(Rank.FOURTH.getMessage() + resultMap.get(Rank.FOURTH) + "개");
        System.out.println(Rank.THIRD.getMessage() + resultMap.get(Rank.THIRD) + "개");
        System.out.println(Rank.SECOND.getMessage() + resultMap.get(Rank.SECOND) + "개");
        System.out.println(Rank.FIRST.getMessage() + resultMap.get(Rank.FIRST) + "개");
    }

    public static void printProfit(double rateOfProfit) {
        System.out.print("총 수익률은 ");
        System.out.printf("%.1f", rateOfProfit);
        System.out.print("%입니다.");
    }

    public static void printOneLine() {
        System.out.println();
    }
}
