package lotto.view;

import static lotto.util.Constant.*;

import java.util.HashMap;
import java.util.List;
import lotto.model.LottoRankings;

public class OutputView {

    public static void printPurchaseAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumberOfPurchaseMessage(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public static void printIssueLottoMessage(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResultMessage(HashMap<LottoRankings, Integer> lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printResult(lottoResult);
    }

    private static void printResult(HashMap<LottoRankings, Integer> lottoResult) {
        for (LottoRankings rank : LottoRankings.values()) {
            if (rank == LottoRankings.NONE) {
                continue;
            }
            if (lottoResult.get(rank) != null) {
                System.out.println(String.format(rank.getMessage(),
                        formatWinningAmount(rank.getWinningAmount()), lottoResult.get(rank)));
                continue;
            }
            System.out.println(String.format(rank.getMessage(),
                    formatWinningAmount(rank.getWinningAmount()), NOTHING));
        }
    }

    public static void printYieldMessage(String yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    private static String formatWinningAmount(int amount) {
        return String.valueOf(amount).replaceAll(WINNING_AMOUNT_PATTERN, DELIMITER);
    }
}
