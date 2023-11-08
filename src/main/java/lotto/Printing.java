package lotto;

import java.util.List;
import lotto.Calculate;

public class Printing {
    private final List<Lotto> lottos;
    private final static String END = "당첨 통계\n---";

    public Printing(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public void printResult(int[] rank, int money) {
        System.out.println(END);

        System.out.println("3개 일치 (5,000원) - " + rank[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + rank[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rank[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rank[1] + "개");

        long totalPrize = 5000 * rank[5] +
                            50000 * rank[4] +
                            1500000 * rank[3] +
                            30000000 * rank[2] +
                            2000000000 * rank[1];
        double percent = totalPrize / money;
        System.out.println("총 수익률은 " + percent + "%입니다.");
    }
}
