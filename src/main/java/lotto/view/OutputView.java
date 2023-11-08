package lotto.view;

import lotto.model.AppConstants;
import lotto.model.LottoTicketEntity;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottoTickets(List<LottoTicketEntity> lottoTickets) {
        for (LottoTicketEntity lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printTicketCount(int lottoTicketCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTicketCount);
    }


    public static void printLottoMatchingResult(Map<String, Integer> lottoMatchingResult, float profitPercent) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printLottoRank(lottoMatchingResult);

        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profitPercent));
    }

    private static void printLottoRank(Map<String, Integer> lottoMatchingResult) {
        for(Map.Entry<String, Integer> entry : lottoMatchingResult.entrySet()) {
            if(entry.getKey().equals(AppConstants.lottoMatchingConstants.MATCHING_3.grade)) {
                System.out.printf("3개 일치 (5,000원) - %d개%n", entry.getValue());
            } else if(entry.getKey().equals(AppConstants.lottoMatchingConstants.MATCHING_4.grade)) {
                System.out.printf("4개 일치 (50,000원) - %d개%n", entry.getValue());
            } else if(entry.getKey().equals(AppConstants.lottoMatchingConstants.MATCHING_5.grade)) {
                System.out.printf("5개 일치 (1,500,000원) - %d개%n", entry.getValue());
            } else if(entry.getKey().equals(AppConstants.lottoMatchingConstants.MATCHING_5_AND_BONUS.grade)) {
                System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", entry.getValue());
            } else if(entry.getKey().equals(AppConstants.lottoMatchingConstants.MATCHING_6.grade)) {
                System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", entry.getValue());
            }
        }
    }
}
