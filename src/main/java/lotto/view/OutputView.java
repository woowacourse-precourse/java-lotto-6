package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.PrizeCondition;

import java.util.Map;

public class OutputView {
    private static final String LOTTO_QUANTITY_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String START_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String FIFTH_PRIZE_RESULT_MESSAGE_FORMAT = "3개 일치 (5,000원) - %d개";
    private static final String FOURTH_PRIZE_RESULT_MESSAGE_FORMAT = "4개 일치 (50,000원) - %d개";
    private static final String THIRD_PRIZE_RESULT_MESSAGE_FORMAT = "5개 일치 (1,500,000원) - %d개";
    private static final String SECOND_PRIZE_RESULT_MESSAGE_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String FIRST_PRIZE_RESULT_MESSAGE_FORMAT = "6개 일치 (2,000,000,000원) - %d개";
    private static final String PROFIT_MESSAGE_FORMAT = "총 수익률은 %f%입니다.";

    public void printLottos(Lottos lottos) {
        System.out.println();
        printLottoQuantity(lottos);
        System.out.println(lottos);
    }

    private static void printLottoQuantity(Lottos lottos) {
        System.out.println(String.format(LOTTO_QUANTITY_MESSAGE_FORMAT, lottos.getLottos().size()));
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
        printFifthPrizeResult(prizeResult.get(PrizeCondition.FIFTH));
        printFourthPrizeResult(prizeResult.get(PrizeCondition.FOURTH));
        printThirdPrizeResult(prizeResult.get(PrizeCondition.THIRD));
        printSecondPrizeResult(prizeResult.get(PrizeCondition.SECOND));
        printFirstPrizeResult(prizeResult.get(PrizeCondition.FIRST));
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
        //TODO profit 출력
        String profitMessage = String.format(PROFIT_MESSAGE_FORMAT, profit);
        System.out.println(profitMessage);
    }
}
