package lotto.view;

import static lotto.model.LottoUtils.*;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;

public class OutputView {

    static final private String lineSeparator = System.lineSeparator();
    static final String MONEY_INPUT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    static final String BONUS_NUMBER_INPUT_REQUEST_MESSAGE =   "보너스 번호를 입력해 주세요.";
    static final String PURCHASING_RESULT_MESSAGE = "개를 구매했습니다.";
    static final String WINNING_NUMBER_INPUT_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String WINNING_RESULT_TITLE = "당첨 통계" + lineSeparator + "---";
    static final String FIFTH_PRIZE_INFORMATION = "3개 일치 (5,000원) - ";
    static final String FOURTH_PRIZE_INFORMATION = "4개 일치 (50,000원) - ";
    static final String THIRD_PRIZE_INFORMATION = "5개 일치 (1,500,000원) - ";
    static final String SECOND_PRIZE_INFORMATION = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    static final String FIRST_PRIZE_INFORMATION = "6개 일치 (2,000,000,000원) - ";
    static final String UNIT = "개";
    public static void  printMoneyInputRequestMessage() {
        System.out.println(MONEY_INPUT_REQUEST_MESSAGE);
    }

    public static void printPurchasingResultMessage(int purchasingNumber, List<Lotto> lottos) {
        System.out.println(purchasingNumber + PURCHASING_RESULT_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printBonusNumberInputRequestMessage() {
        System.out.println(BONUS_NUMBER_INPUT_REQUEST_MESSAGE);
    }

    public static void printWinningNumberInputRequestMessage() {
        System.out.println(WINNING_NUMBER_INPUT_REQUEST_MESSAGE);
    }

    public static void printWinningResultTitle() {
        System.out.println(WINNING_RESULT_TITLE);
    }

    public static void printWinningResult(Map<Integer, Integer> winningResult) {
        System.out.println(FIFTH_PRIZE_INFORMATION + winningResult.get(FIFTH_PRIZE) + UNIT);
        System.out.println(FOURTH_PRIZE_INFORMATION + winningResult.get(FOURTH_PRIZE) + UNIT);
        System.out.println(THIRD_PRIZE_INFORMATION + + winningResult.get(THIRD_PRIZE) + UNIT);
        System.out.println(SECOND_PRIZE_INFORMATION + winningResult.get(SECOND_PRIZE) + UNIT);
        System.out.println(FIRST_PRIZE_INFORMATION + winningResult.get(FIRST_PRIZE) + UNIT);
    }

    public static void printEarningRateResultMessage(String earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }

    public static void printLottoResult(Map<Integer, Integer> winningResult, String earningRate) {
        printWinningResultTitle();
        printWinningResult(winningResult);
        printEarningRateResultMessage(earningRate);
    }

    public static void printErrorMessage(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }
}
