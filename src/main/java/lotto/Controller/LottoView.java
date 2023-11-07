package lotto.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

public class LottoView {
    public static int promptForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        System.out.println();
        return purchaseAmount;
    }

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static List<Integer> promptForWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return parseNumbers(input);
    }

    public static int promptForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonusNumber;
    }

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

    public static void printResult() {
        System.out.println("당첨통계\n---");
    }

    public static void printRank(int[] rankCounts) {
        System.out.println("3개 일치 (5,000원) - " + rankCounts[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCounts[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCounts[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts[0] + "개");
    }

    public static void printProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

}
