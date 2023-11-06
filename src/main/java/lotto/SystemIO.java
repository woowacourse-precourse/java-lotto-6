package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class SystemIO {
    public static String requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public static List<Integer> requestWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readWinningNumbers();
    }

    private static List<Integer> readWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        List<String> stringWinningNumbers = Arrays.asList(readLine().split(","));
        for (String stringWinningNumber : stringWinningNumbers) {
            try {
                winningNumbers.add(Integer.parseInt(stringWinningNumber));
            } catch (NumberFormatException e) {
                throw new IllegalStateException();
            }
        }
        return winningNumbers;
    }

    public static int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readBonusNumber();
    }

    private static int readBonusNumber() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalStateException();
        }
    }

    public static void showTickets(Map<Long, List<Integer>> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (List<Integer> ticket : tickets.values()) {
            System.out.println(ticket);
        }
    }

    public static void showResult() {
    }
}
