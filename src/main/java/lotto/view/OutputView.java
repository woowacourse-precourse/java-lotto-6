package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.Prize;

public class OutputView {
    private static final String PRIZE_FORMAT = "%d개 일치 (%s) - %d개\n";
    private static final String PRIZE_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s) - %d개\n";

    public void printUserLotto(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(
                    lotto.getLotto().stream()
                            .sorted(Comparator.naturalOrder())
                            .collect(Collectors.toList())
            );
        }
    }

    public void printWinningStatistics(List<Integer> prizes, double profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.format(PRIZE_FORMAT, Prize.FIFTH.getMatchNum(), "5,000원", prizes.get(4));
        System.out.format(PRIZE_FORMAT, Prize.FOURTH.getMatchNum(), "50,000원", prizes.get(3));
        System.out.format(PRIZE_FORMAT, Prize.THIRD.getMatchNum(), "1,500,000원", prizes.get(2));
        System.out.format(PRIZE_BONUS_FORMAT, Prize.SECOND.getMatchNum(), "30,000,000원", prizes.get(1));
        System.out.format(PRIZE_FORMAT, Prize.FIRST.getMatchNum(), "2,000,000,000원", prizes.get(0));
        System.out.format("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
