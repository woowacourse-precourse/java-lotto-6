package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.PrizeCondition;

import java.util.Map;

public class OutputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_QUANTITY_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String START_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String FIFTH_PRIZE_RESULT_MESSAGE_FORMAT = "3개 일치 (5,000원) - %d개";
    private static final String FOURTH_PRIZE_RESULT_MESSAGE_FORMAT = "4개 일치 (50,000원) - %d개";
    private static final String THIRD_PRIZE_RESULT_MESSAGE_FORMAT = "5개 일치 (1,500,000원) - %d개";
    private static final String SECOND_PRIZE_RESULT_MESSAGE_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String FIRST_PRIZE_RESULT_MESSAGE_FORMAT = "6개 일치 (2,000,000,000원) - %d개";
    private static final String PROFIT_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printAskPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
    }

    public void printAskWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
    }

    public void printAskBonusNumber() {
        System.out.println();
        System.out.println(ASK_BONUS_NUMBER);
    }

    public void printLottos(Lottos lottos) {
        System.out.println();
        printLottoQuantity(lottos.getLottos().size());
        System.out.println(lottos);
    }

    private static void printLottoQuantity(long size) {
        System.out.printf((LOTTO_QUANTITY_MESSAGE_FORMAT) + "%n", size);
    }

    public void printResult(Map<PrizeCondition, Long> prizeResult, double profit) {
        printStartResult();
        printPrizeResult(prizeResult);
        printProfit(profit);
    }

    private void printStartResult() {
        System.out.println();
        System.out.println(START_RESULT_MESSAGE);
    }

    private static void printPrizeResult(Map<PrizeCondition, Long> prizeResult) {
        printFifthPrizeResult(prizeResult.getOrDefault(PrizeCondition.FIFTH, 0L));
        printFourthPrizeResult(prizeResult.getOrDefault(PrizeCondition.FOURTH, 0L));
        printThirdPrizeResult(prizeResult.getOrDefault(PrizeCondition.THIRD, 0L));
        printSecondPrizeResult(prizeResult.getOrDefault(PrizeCondition.SECOND, 0L));
        printFirstPrizeResult(prizeResult.getOrDefault(PrizeCondition.FIRST, 0L));
    }

    private static void printFifthPrizeResult(long count) {
        String fifthPrizeResultMessage = String.format(FIFTH_PRIZE_RESULT_MESSAGE_FORMAT, count);
        System.out.println(fifthPrizeResultMessage);
    }

    private static void printFourthPrizeResult(long count) {
        String fourthPrizeResultMessage = String.format(FOURTH_PRIZE_RESULT_MESSAGE_FORMAT, count);
        System.out.println(fourthPrizeResultMessage);
    }

    private static void printThirdPrizeResult(long count) {
        String thirdPrizeResultMessage = String.format(THIRD_PRIZE_RESULT_MESSAGE_FORMAT, count);
        System.out.println(thirdPrizeResultMessage);
    }

    private static void printSecondPrizeResult(long count) {
        String secondPrizeResultMessage = String.format(SECOND_PRIZE_RESULT_MESSAGE_FORMAT, count);
        System.out.println(secondPrizeResultMessage);
    }

    private static void printFirstPrizeResult(long count) {
        String firstPrizeResultMessage = String.format(FIRST_PRIZE_RESULT_MESSAGE_FORMAT, count);
        System.out.println(firstPrizeResultMessage);
    }

    private static void printProfit(double profit) {
        String profitMessage = String.format(PROFIT_MESSAGE_FORMAT, profit);
        System.out.println(profitMessage);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
