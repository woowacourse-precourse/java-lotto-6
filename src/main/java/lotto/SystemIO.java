package lotto;

import java.util.List;
import java.util.Map;

public class SystemIO {
    public static void requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestWinningNumber() {
    }

    public static List<Integer> readWinningNumbers() {
        List<Integer> winningNumbers = null;
        return winningNumbers;
    }

    public static void showTickets(Map<Long,List<Integer>> tickets) {
        System.out.println("8개를 구매했습니다.");
        for (List<Integer> ticket : tickets.values()) {
            System.out.println(ticket);
        }

    }
    public static void showResult() {
    }
}
