package lotto.view;

public class OutputView {

    private OutputView() {

    }

    protected void printReadPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    protected void printPurchaseLottoCountMessage(int purchaseLottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", purchaseLottoCount);
    }

    protected void printReadLottoNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    protected void printReadBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    // 전체 당첨 통계 출력
    protected static void printWinningStatusMessage(List<PrizeResponse> prizeResponses, double profitRate) {
        printWinningResultMessage();
        printLineSeparator();
        for (PrizeResponse prizeResponse : prizeResponses) {
            printPrizeMessage(prizeResponse);
        }
        printProfitRateMessage(profitRate);
    }

    private static void printWinningResultMessage() {
        System.out.println(PrizeMessage.WINNING_STATUS.getMessage());
    }

    private static void printLineSeparator() {
        System.out.println(PrizeMessage.LINE_SEPARATOR.getMessage());
    }

    // 개별 당첨 통계 출력
    private static void printPrizeMessage(PrizeResponse prizeResponse) {
        printMatchingNumberCount(prizeResponse.getMatchingNumberCount());
        if (isBonusCondition(prizeResponse.getPrize())) {
            printBonusConditionMessage();
        }
        printPrizeMoneyMessage(prizeResponse.getPrizeMoney());
        printWinningCountMessage(prizeResponse.getWinningCount());
        printLineBreak();
    }

    private static void printMatchingNumberCount(int matchingNumberCount) {
        System.out.printf(PrizeMessage.MATCHING_NUMBER_COUNT.getMessage(), matchingNumberCount);
    }

    private static boolean isBonusCondition(Prize prize) {
        return Objects.equals(prize, Prize.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH);
    }

    private static void printBonusConditionMessage() {
        System.out.print(PrizeMessage.MATCHING_BONUS_NUMBER.getMessage());
    }

    private static void printPrizeMoneyMessage(int prizeMoney) {
        DecimalFormat decimalFormat = new DecimalFormat(PrizeMessage.MONEY_FORMAT.getMessage());
        System.out.printf(PrizeMessage.PRIZE_MONEY.getMessage(), decimalFormat.format(prizeMoney));
    }

    private static void printWinningCountMessage(int winningCount) {
        System.out.printf(PrizeMessage.WINNING_COUNT.getMessage(), winningCount);
    }

    private static void printLineBreak() {
        System.out.println();
    }

    protected static void printProfitRateMessage(double profitRate) {
        System.out.printf(PrizeMessage.PROFIT_RATE.getMessage(), profitRate);
    }
}
