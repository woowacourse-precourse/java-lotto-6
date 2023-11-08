package lotto.view;

import java.util.List;

public class OutputView {

    public static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static final String INFORM_PURCHASE_MESSAGE = "개를 구매했습니다.";

    public static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";

    public static final String DIVIDING_LINE = "---";

    public static final String THREE_MATCH_MESSAGE = "3개 일치 (5,000원) - ";

    public static final String FOUR_MATCH_MESSAGE = "4개 일치 (50,000원) - ";

    public static final String FIVE_MATCH_MESSAGE = "5개 일치 (1,500,000원) - ";

    public static final String FIVE_BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";

    public static final String SIX_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - ";

    public static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 ";

    public void printInputPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printInformPurchaseMessage(int lottoTicket) {
        System.out.println("\n" + lottoTicket + INFORM_PURCHASE_MESSAGE);
    }

    public void printInputWinningNumberMessage() {
        System.out.println("\n" + INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void printInputBonusNumberMessage() {
        System.out.println("\n" + INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatisticsMessage(List<Integer> resultData) {
        System.out.println("\n" + WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDING_LINE);
        System.out.println(THREE_MATCH_MESSAGE + resultData.get(0) + "개");
        System.out.println(FOUR_MATCH_MESSAGE + resultData.get(1) + "개");
        System.out.println(FIVE_MATCH_MESSAGE + resultData.get(2) + "개");
        System.out.println(FIVE_BONUS_MATCH_MESSAGE + resultData.get(3) + "개");
        System.out.println(SIX_MATCH_MESSAGE + resultData.get(4) + "개");
    }

    public void printRateOfReturnMessage(double rateOfReturn) {
        System.out.println(RATE_OF_RETURN_MESSAGE + rateOfReturn + "%입니다.");
    }
}
