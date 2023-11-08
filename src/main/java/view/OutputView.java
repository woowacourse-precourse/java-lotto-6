package view;

import domain.Lotto;
import domain.Ranking;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int LOSING_TICKET = 0;
    private static final int LOTTO_PRICE = 1000;

    public static void printInputSpend() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseCount(int spend) {
        System.out.printf("\n%d개를 구매했습니다.\n", spend / LOTTO_PRICE);
    }

    public static void printLottoNumbers(List<Lotto> lottoTickets) {
        for (Lotto lottoNumbers : lottoTickets) {
            System.out.println(lottoNumbers);
        }
    }

    public static void printInputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printLottoResult(Map<Ranking, Integer> lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResult.getOrDefault(Ranking.FIFTH, LOSING_TICKET));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResult.getOrDefault(Ranking.FOURTH, LOSING_TICKET));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResult.getOrDefault(Ranking.THIRD, LOSING_TICKET));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
                lottoResult.getOrDefault(Ranking.SECOND, LOSING_TICKET));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResult.getOrDefault(Ranking.FIRST, LOSING_TICKET));
    }

    public static void printEarningsRate(double earningsRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", earningsRate);
    }
}
