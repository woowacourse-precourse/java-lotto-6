package lotto.view;

import lotto.domain.Player;
import lotto.domain.Rank;

import java.util.Map;

public class OutputView {
    public static void showPlayerLotto(Player player, int lottoCount) {
        System.out.printf("%n%d개를 구매했습니다.%n", lottoCount);
        player.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void showPlayerWinningStatistics(Player player, int inputMoney) {
        System.out.printf("%n당첨 통계%n");
        System.out.println("---");

        showPrizeMoney(player.getWinningDetails());

        System.out.printf("총 수익률은 %.1f%%입니다.", player.calculateRateOfReturn(inputMoney));
    }

    private static void showPrizeMoney(Map<Rank, Integer> winningDetails) {
        for(Map.Entry<Rank, Integer> entry : winningDetails.entrySet()) {
            Rank rank = entry.getKey();
            if (rank.isBlank()) {
                continue;
            }

            System.out.printf("%s%d개%n", rank.getShowPrizeMoney(), entry.getValue());
        }
    }
}
