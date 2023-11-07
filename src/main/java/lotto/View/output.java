package lotto.View;

import lotto.Lotto;

import java.util.List;
import java.util.Map;

import lotto.Model.Prize;

public class output {
    public static void printLotto(List<Lotto> lottoTickets) {
        int purchaseAmount = lottoTickets.size();
        System.out.println(purchaseAmount + "개를 구매했습니다.");

        for (Lotto lottoTicket : lottoTickets) {
            List<Integer> numbers = lottoTicket.getNumbers();
            System.out.println(numbers);
        }
    }

    public static void printResults(Map<String, Integer> results, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (String key : results.keySet()) {
            if (results.containsKey(key)) {
                printResultLine(key, results.get(key));
            }
        }
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }

    public static void printResultLine(String key, int count) {
        if ("5.1".equals(key)) {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
        } else if (Double.parseDouble(key) >= 3) {
            String prize = Prize.getPrize(key);
            System.out.println(key + "개 일치 (" + prize + "원) - " + count + "개");
        }
    }
}
