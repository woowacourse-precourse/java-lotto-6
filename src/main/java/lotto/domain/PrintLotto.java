package lotto.domain;

import java.util.List;

public class PrintLotto {
    static public void print(List<Integer> rank, int buy) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", rank.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", rank.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", rank.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", rank.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", rank.get(0));
        System.out.println("총 수익률은 " + String.format("%.1f", (rank.get(5) / (float) buy * 100.0)) + "%입니다.\n");
    }
}