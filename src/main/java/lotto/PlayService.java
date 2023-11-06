package lotto;

import java.util.HashMap;

public class PlayService {
    public static void printNumberOfLottoTickets(int purchaseNumber) {
        System.out.printf("%d개를 구매했습니다.", purchaseNumber);
    }

    public static void printStringForResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printResults(HashMap<Integer, Integer> results) {
        for (int caseNumber : results.keySet()) {
            System.out.printf(WinnigCase.getByCaseNumber(caseNumber).getContents()
                    + " - %d개", results.get(caseNumber));
        }
    }

    public static void printRateOrReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %f입니다.", rateOfReturn);
    }


}
