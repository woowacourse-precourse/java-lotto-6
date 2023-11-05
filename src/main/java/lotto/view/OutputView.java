package lotto.view;

import lotto.model.LottoTicket;
import lotto.model.Rank;
import lotto.model.ResultDetails;

public final class OutputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String HORIZONTAL_LINE = "---";
    private static final String THREE_MATCH_PRIZE_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String FOUR_MATCH_PRIZE_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private static final String FIVE_MATCH_PRIZE_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String FIVE_MATCH_WITH_BONUS_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String SIX_MATCH_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private OutputView() {
    }

    public static void printPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printNumberOfLotto(final int NumberOfLotto) {
        printEmptyLine();
        System.out.printf(PURCHASE_MESSAGE, NumberOfLotto);
    }

    public static void printLottoTicket(final LottoTicket lottoTicket) {
        lottoTicket.getLottos()
                .forEach(System.out::println);
    }

    public static void printWinningNumbersMessage() {
        printEmptyLine();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        printEmptyLine();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printWinningStatisticsHeader() {
        printEmptyLine();
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(HORIZONTAL_LINE);
    }

    public static void printWinningStatistics(final ResultDetails resultDetails) {
        System.out.printf(THREE_MATCH_PRIZE_MESSAGE, resultDetails.getWinnerCountByRank(Rank.FIFTH));
        System.out.printf(FOUR_MATCH_PRIZE_MESSAGE, resultDetails.getWinnerCountByRank(Rank.FOURTH));
        System.out.printf(FIVE_MATCH_PRIZE_MESSAGE, resultDetails.getWinnerCountByRank(Rank.THIRD));
        System.out.printf(FIVE_MATCH_WITH_BONUS_PRIZE_MESSAGE, resultDetails.getWinnerCountByRank(Rank.SECOND));
        System.out.printf(SIX_MATCH_PRIZE_MESSAGE, resultDetails.getWinnerCountByRank(Rank.FIRST));
    }

    public static void printExceptionMessage(final String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public static void printProfitRate(final double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
