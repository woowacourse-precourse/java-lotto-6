package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Print {
    protected void purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    protected void ticketCount(int ticketCount) {
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    protected void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    protected void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    protected void lottoTickets(List<Lotto> lottoTickets) {
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }

    protected void rateOfReturn(int revenue, int winnings) {
        double rateOfReturn = (double) winnings / revenue * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }

    protected void printWinningResult(Map<String, Integer> matchCounts, Map<String, Integer> prizeMoney) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<String> sortedKeys = new ArrayList<>(List.of("3", "4", "5", "5+bonus", "6"));

        for (String key : sortedKeys) {
            Integer count = matchCounts.getOrDefault(key, 0);
            String matchMessage = key.equals("5+bonus") ?
                    "5개 일치, 보너스 볼 일치" :
                    key + "개 일치";
            System.out.println(matchMessage + " (" + String.format("%,d", prizeMoney.get(key)) + "원) - " + count + "개");
        }
    }
}
