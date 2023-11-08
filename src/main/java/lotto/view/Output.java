package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class Output {
    private static final String MESSAGE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String MESSAGE_WINNING_STATISTICS = "당첨 통계";
    private static final String FORMAT_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String FORMAT_RESULT_MESSAGE = "%s - %d개";
    private static final String FORMAT_TOTAL_RETURN = "총 수익률은 %.1f%%입니다.";


    public static void getMessageOfPurchaseLotto() {
        System.out.println(MESSAGE_PURCHASE_MONEY);
    }

    public static void getFormatOfPurchaseMessage(int lottoCount) {
        System.out.printf("\n" + FORMAT_PURCHASE_MESSAGE + "\n", lottoCount);
    }

    public static void printLottoList(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void getErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void getMessageOfInputWinningNumber() {
        System.out.println("\n" + MESSAGE_WINNING_NUMBER);
    }

    public static void getMessageOfInputBonusNumber() {
        System.out.println("\n" + MESSAGE_BONUS_NUMBER);
    }

    public static void getMessageOfWinningStatistics() {
        System.out.println("\n" + MESSAGE_WINNING_STATISTICS + "\n" + "---");
    }

    public static void getMessageOfResult(HashMap<Rank, Integer> result) {
        List<Rank> rankOrder = List.of(Rank.FIFTH_PLACE, Rank.FOURTH_PLACE, Rank.THIRD_PLACE, Rank.SECOND_PLACE, Rank.FIRST_PLACE);
        Output.getMessageOfWinningStatistics();
        for (Rank rank : rankOrder) {
            System.out.printf(FORMAT_RESULT_MESSAGE + "\n", rank.getSentence(), result.get(rank));
        }
    }

    public static void getFormatOfTotalReturn(double totalReturn) {
        System.out.printf(FORMAT_TOTAL_RETURN, totalReturn);
    }
}
