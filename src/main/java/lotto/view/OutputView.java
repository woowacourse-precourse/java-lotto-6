package lotto.view;

import lotto.domain.PrizeCondition;
import lotto.dto.PurchasedLottosDto;

import java.util.Map;
import java.util.stream.Collectors;

import static lotto.view.OutputViewMessage.*;

public class OutputView {
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

    public void printLottos(PurchasedLottosDto purchasedLottosDto) {
        System.out.println();
        printLottoQuantity(purchasedLottosDto.getSize());
        printPurchasedLottos(purchasedLottosDto);
    }

    private static void printLottoQuantity(long size) {
        System.out.printf((LOTTO_QUANTITY_MESSAGE_FORMAT) + "%n", size);
    }

    private void printPurchasedLottos(PurchasedLottosDto purchasedLottosDto) {
        purchasedLottosDto.getLottos().stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(PURCHASED_LOTTO_NUMBERS_DELIMITER, PURCHASED_LOTTO_PREFIX, PURCHASED_LOTTO_SUFFIX)))
                .collect(Collectors.joining(PURCHASED_LOTTOS_DELIMITER));
    }

    public void printResult(Map<PrizeCondition, Long> prizeResult, double profit) {
        printStartResult();
        printPrizeResult(prizeResult);
        printProfit(profit);
    }

    private void printStartResult() {
        System.out.println();
        System.out.println(START_RESULT);
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
