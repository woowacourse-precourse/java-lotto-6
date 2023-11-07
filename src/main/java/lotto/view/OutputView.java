package lotto.view;

import lotto.model.AnalyzerWinningStatistics;
import lotto.model.BuyerLottoHistory;

public class OutputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String MAIN_WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_START = "당첨 통계\n---";

    public static void printPurchaseAmountPrompt() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
    }

    public static void printMainWinningNumbersPrompt() {
        System.out.println();
        System.out.println(MAIN_WINNING_NUMBERS_PROMPT);
    }

    public static void printBonusNumberPrompt() {
        System.out.println();
        System.out.println(BONUS_NUMBER_PROMPT);
    }

    public static void printBuyerLottoHistory(BuyerLottoHistory buyerLottoHistory) {
        printBuyerLottoCount(buyerLottoHistory);
        printBuyerLottoNumbers(buyerLottoHistory);
    }

    public static void printAnalyzerWinningStatistics(AnalyzerWinningStatistics analyzerWinningStatistics) {
        printWinningStatisticsStart();
        printWinningResults(analyzerWinningStatistics);
        printWinningYield(analyzerWinningStatistics);
    }

    private static void printBuyerLottoCount(BuyerLottoHistory buyerLottoHistory) {
        System.out.println();
        System.out.println(buyerLottoHistory.formatBuyerLottoCount());
    }

    private static void printBuyerLottoNumbers(BuyerLottoHistory buyerLottoHistory) {
        System.out.println(buyerLottoHistory.formatBuyerLottos());
    }

    private static void printWinningStatisticsStart() {
        System.out.println();
        System.out.println(WINNING_STATISTICS_START);
    }

    private static void printWinningResults(AnalyzerWinningStatistics analyzerWinningStatistics) {
        System.out.println(analyzerWinningStatistics.formatWinningResults());
    }

    private static void printWinningYield(AnalyzerWinningStatistics analyzerWinningStatistics) {
        System.out.println(analyzerWinningStatistics.formatWinningYield());
    }
}
