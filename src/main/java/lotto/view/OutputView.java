package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class OutputView {

    public void printUserLotto(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottos) {
            System.out.println(
                    lotto.getLotto().stream()
                            .sorted(Comparator.naturalOrder())
                            .collect(Collectors.toList())
            );
        }
    }

    public void printWinningStatistics(List<Integer> prizes, double TotalReturn) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개", prizes.get(4)).println();
        System.out.printf("4개 일치 (50,000원) - %d개", prizes.get(3)).println();
        System.out.printf("5개 일치 (1,500,000원) - %d개", prizes.get(2)).println();
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", prizes.get(1)).println();
        System.out.printf("6개 일치 (2,000,000,000원) - %d개", prizes.get(0)).println();
        System.out.printf("총 수익률은 %.1f%%입니다.", TotalReturn).println();
    }
}
