package lotto.view;

import lotto.domain.Prize;
import lotto.util.ProfitRate;

public class OutputView {
    public static void printRequestLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoTicketCount(int lottoTicketCount) {
        System.out.println("\n" + lottoTicketCount + "개를 구매했습니다.");
    }

    public static void printRequestWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printTotalStats(Prize prize, int count) {
        System.out.println(prize.getDescription() + " - " + count + "개");
    }

    public static void printPrizeStaticIntro() {
        System.out.println("\n당첨통계");
        System.out.println("---");
    }

    public static void printProfitRate(int totalWinnings, int lottoCost) {
        System.out.println("총 수익률은 " + ProfitRate.calculateProfit(totalWinnings, lottoCost) + "%입니다.");
    }

}
