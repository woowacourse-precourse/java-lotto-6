package lotto;

import java.util.List;

public class OutputWin {
    public void print(List<Integer> win_counts) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", win_counts.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", win_counts.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", win_counts.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", win_counts.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", win_counts.get(4));
    }
}
