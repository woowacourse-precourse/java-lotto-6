package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Rank;

public class OutputView {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String WINNING_STATISTICS_DIVIDER = "---";
    private static final String FIFTH_PLACE_RESULT_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String FOURTH_PLACE_RESULT_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_PLACE_RESULT_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_PLACE_RESULT_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_PLACE_RESULT_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %s%%입니다.";

    public void printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_PURCHASE_MESSAGE, lottoCount);
    }

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public void printWinningNumbersInputMessage() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printWinningStatistics(Map<Rank, Integer> winningStatistics) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(WINNING_STATISTICS_DIVIDER);
        System.out.printf(FIFTH_PLACE_RESULT_MESSAGE, winningStatistics.get(Rank.FifthPlace));
        System.out.printf(FOURTH_PLACE_RESULT_MESSAGE, winningStatistics.get(Rank.FourthPlace));
        System.out.printf(THIRD_PLACE_RESULT_MESSAGE, winningStatistics.get(Rank.ThirdPlace));
        System.out.printf(SECOND_PLACE_RESULT_MESSAGE, winningStatistics.get(Rank.SecondPlace));
        System.out.printf(FIRST_PLACE_RESULT_MESSAGE, winningStatistics.get(Rank.FirstPlace));
    }

    public void printTotalYield(String totalYield) {
        System.out.printf(TOTAL_YIELD_MESSAGE, totalYield);
    }
}
