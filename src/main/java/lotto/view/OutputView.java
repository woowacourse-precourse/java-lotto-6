package lotto.view;

import static lotto.util.Constant.*;

import java.util.HashMap;
import java.util.List;
import lotto.model.LottoRankings;

public class OutputView {

    private enum Message {
        PURCHASE_AMOUNT_INPUT("구입금액을 입력해 주세요."),
        NUMBER_OF_PURCHASE("개를 구매했습니다."),
        WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
        WINNING_STATISTICS("당첨 통계"),
        LINE("---"),
        YIELD("총 수익률은 %s%%입니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static void printPurchaseAmountInputMessage() {
        System.out.println(Message.PURCHASE_AMOUNT_INPUT.getMessage());
    }

    public static void printNumberOfPurchaseMessage(int number) {
        System.out.println(number + Message.NUMBER_OF_PURCHASE.getMessage());
    }

    public static void printIssueLottoMessage(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println(Message.WINNING_NUMBERS_INPUT.getMessage());
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(Message.BONUS_NUMBER_INPUT.getMessage());
    }

    public static void printResultMessage(HashMap<LottoRankings, Integer> lottoResult) {
        System.out.println(Message.WINNING_STATISTICS.getMessage());
        System.out.println(Message.LINE.getMessage());
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
        System.out.println(String.format(Message.YIELD.getMessage(), yield));
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    private static String formatWinningAmount(int amount) {
        return String.valueOf(amount).replaceAll(WINNING_AMOUNT_PATTERN, DELIMITER);
    }
}
