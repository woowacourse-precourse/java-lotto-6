package lotto.view;

import lotto.model.Lotto;
import lotto.model.Percent;
import lotto.model.Ranking;

import java.util.List;
import java.util.Map;

public class ConsoleView {
    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printTicketCount(int count) {
        System.out.printf(("\n%d개를 구매했습니다.\n"), count);
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printPriceExplanation() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printWinningNumberExplanation() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberExplanation() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printRankingResult(Map<Ranking, Integer> rankingCounts) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Ranking ranking: Ranking.values()) {
            int rankingCount = rankingCounts.get(ranking);
            System.out.printf((ranking + " - %d개\n"), rankingCount);
        }
    }

    public static void printIncomeRate(Percent incomeRate) {
        System.out.println("총 수익률은 " + incomeRate + "입니다.");
    }
}
