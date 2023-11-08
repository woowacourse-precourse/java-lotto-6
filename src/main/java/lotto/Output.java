package lotto;

import java.text.DecimalFormat;

public class Output {
    public static void getPriceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void viewTicketCountMessage(int lottoCnt) {
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }

    public static void viewlottoTicketNumList(Lotto numberGroup) {
        System.out.println(numberGroup.getNumbers());
    }

    public static void getLotteryNumsMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void getBonusNumMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void viewResult() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMatchStandard() + " (" + decimalFormat.format(rank.getPrice()) + "원) - " + rank.getCount() + "개");
        }
    }

    public static void viewRate(double rate) {
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }
}
