package view;

import constant.Rank;
import java.util.HashMap;

public class OutputView {
    private OutputView() {
    }

    public static long LottoTicketCount(long money) {
        long ticketCount = money / 1000;
        String output = String.format("%d개를 구매했습니다.", ticketCount);

        System.out.println(output);
        return ticketCount;
    }

    public static void resultStart() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printStatistics(HashMap<Rank, Integer> rankCountsMap) {
        System.out.println("3개 일치 (5,000원)" + " - " + rankCountsMap.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원)" + " - " + rankCountsMap.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원)" + " - " + rankCountsMap.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)" + " - " + rankCountsMap.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원)" + " - " + rankCountsMap.get(Rank.FIRST) + "개");
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public static void errorMessage(IllegalArgumentException error) {
        System.out.println(error.getMessage());
    }
}
