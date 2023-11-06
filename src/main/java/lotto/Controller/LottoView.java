package lotto.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;

public class LottoView {
    public static int promptForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> promptForWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseNumbers(input);
    }

    public static int promptForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    /*
     * public static void printWinningStatistics(WinningStatistics stats) {
     * System.out.println("당첨 통계\n---");
     * // 등수별 당첨 결과 출력
     * }
     */

    /*
     * public static void printProfitRate(double profitRate) {
     * System.out.println("총 수익률은 " + profitRate + "%입니다.");
     * }
     */

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    // ","을 기준으로 숫자를 나누어 List에 넣는 메서드
    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
