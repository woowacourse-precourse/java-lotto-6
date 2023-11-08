package lotto.view;

import lotto.config.Prize;
import lotto.domain.lotto.Lotto;
import lotto.dto.response.PrizeResponse;
import lotto.util.OutputUtil;
import lotto.view.constant.PrizeMessage;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class OutputView {

    private OutputView() {

    }

    protected static void printReadPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    protected static void printPurchasedLottoCountMessage(int purchasedLottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", purchasedLottoCount);
    }

    protected static void printWinningLottos(List<Lotto> winningLottos) {
        winningLottos.forEach(lotto -> System.out.println(OutputUtil.lottoFormat(lotto)));
    }

    protected static void printReadLottoNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    protected static void printReadBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    // 전체 당첨 통계 출력
    protected static void printWinningStatusMessage(List<PrizeResponse> prizeResponses, double profitRate) {
        printWinningResultMessage();
        printLineSeparator();
        for (Prize prize : Prize.values()) {
            if (Objects.equals(prize, Prize.NONE)) {
                continue;
            }
            printPrizeMessage(prize, prizeResponses);
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
    private static void printPrizeMessage(Prize prize, List<PrizeResponse> prizeResponses) {
        printMatchingNumberCount(prize.getMatchingNumberCount());
        if (isBonusCondition(prize)) {
            printBonusConditionMessage();
        }
        printPrizeMoneyMessage(prize.getPrizeMoney());
        int winningCount = 0;
        for (PrizeResponse prizeResponse : prizeResponses) {
            if (Objects.equals(prize, prizeResponse.getPrize())) {
                winningCount = prizeResponse.getWinningCount();
            }
        }
        printWinningCountMessage(winningCount);
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

    public static void printLineBreak() {
        System.out.println();
    }

    protected static void printProfitRateMessage(double profitRate) {
        System.out.printf(PrizeMessage.PROFIT_RATE.getMessage(), profitRate);
    }
}
