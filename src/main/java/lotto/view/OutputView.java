package lotto.view;

import lotto.model.Prize;
import lotto.utils.FormatUtils;

import java.util.List;

public class OutputView {

    private static final String INPUT_BUY_AMOUNT = "구매 금액을 입력하세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력하세요.";
    private static final String PURCHASED_TICKET_COUNT= "%d개를 구매했습니다.\n";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String MESSAGE_TOTAL_PROFIT = "총 수익률은 %s%%입니다.\n";
    private static final String WINNING_STATISTICS = "당첨 통계";
    public static final String HORIZONTAL_LINE = "---";

    public static void printInputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT);
    }

    public static void printInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public static void printPurchaseTicketCount(int ticketCounts) {
        System.out.printf(PURCHASED_TICKET_COUNT, ticketCounts);
    }

    public static void printUserLottoNumbers(List<List<Integer>> userLottoNumbers) {
        for (List<Integer> userLotto : userLottoNumbers) {
            System.out.println(userLotto);
        }
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printTotalProfit(String formattedProfitRate) {
        System.out.printf(MESSAGE_TOTAL_PROFIT,formattedProfitRate);
    }

    public static void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS);
    }

    public static void printHorizontalLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    public static void printTotalPrizeResult(Prize prize) {
        String formattedPrice = FormatUtils.formatPriceWithCommas(prize.getPrice());
        System.out.printf(prize.getMessage(),formattedPrice,prize.getCount());
    }
    
}
