package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.Prize.*;

public class Output {
    public void outputPurchaseAmount() {
        System.out.println("구입금액을 입력 주세요.");
    }

    public void outputTicketPurchaseHistory(int ticket, List<List<Integer>> allTicketNumbers) {
        System.out.println(ticket + "개를 구했습니다.");
        for (int i = 0; i < ticket; i++) {
            System.out.println(allTicketNumbers.get(i));
        }
    }

    public void outputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void outputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void outputResult(Map<Integer, Integer> ticketResults, double yieldRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        System.out.println("3개 일치 (" + decimalFormat.format(FIFTH.getPrizeMoney()) + "원) - " + ticketResults.get(5) + "개");
        System.out.println("4개 일치 (" + decimalFormat.format(FOURTH.getPrizeMoney()) + "원) - " + ticketResults.get(4) + "개");
        System.out.println("5개 일치 (" + decimalFormat.format(THIRD.getPrizeMoney()) + "원) - " + ticketResults.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + decimalFormat.format(SECOND.getPrizeMoney()) + "원) - " + ticketResults.get(2) + "개");
        System.out.println("6개 일치 (" + decimalFormat.format(FIRST.getPrizeMoney()) + "원) - " + ticketResults.get(1) + "개");
        System.out.println("총 수익률은 " + yieldRate + "%입니다.");
    }
}