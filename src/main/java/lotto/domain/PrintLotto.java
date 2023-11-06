package lotto.domain;

import java.util.List;

public class PrintLotto {
    static public void print(List<Integer> rank, int buy) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개", rank.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개", rank.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개", rank.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", rank.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개", rank.get(0));
        System.out.printf("총 수익률은 %d%입니다.", (rank.get(5) / buy) * 100);
    }
}