package lotto.view;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    public void printAmount(int Amount) {
        System.out.println();
        System.out.println(Amount + "개를 구매했습니다.");
    }

    public void printLotto(List<Integer> lotto) {
        int index = 1;
        System.out.print("[");
        for (int value : lotto) {
            System.out.print(value);
            if (index != 6) {
                System.out.print(", ");
            }
            index++;
        }
        System.out.println("]");
    }

    public void printResult(int[] ranking, double rate) {
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--");
        System.out.println("3개 일치 (5,000원) - " + ranking[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + ranking[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranking[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranking[6] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranking[7] + "개");
        System.out.println("총 수익률은 " + formatter.format(rate) + "%입니다.");
    }
}
