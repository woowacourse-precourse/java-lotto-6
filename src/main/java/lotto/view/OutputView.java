package lotto.view;

import lotto.domain.PrizeCondition;
import lotto.dto.PurchasedLottosDto;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.view.OutputViewMessage.*;

public class OutputView {
    private static void printLottoQuantity(long size) {
        System.out.printf((LOTTO_QUANTITY_MESSAGE_FORMAT) + "%n", size);
    }

    private static void printPrizeResult(Map<PrizeCondition, Long> prizeResult) {
        Arrays.stream(PrizeCondition.values())
                .filter(prizeCondition -> !prizeCondition.equals(PrizeCondition.NONE))
                .forEach(prizeCondition ->
                        System.out.printf((prizeCondition.getPrizeResultFormat()) + "%n",
                                prizeResult.getOrDefault(prizeCondition, 0L)));
    }

    private static void printProfit(double profit) {
        String profitMessage = String.format(PROFIT_MESSAGE_FORMAT, profit);
        System.out.println(profitMessage);
    }

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

    private void printPurchasedLottos(PurchasedLottosDto purchasedLottosDto) {
        String result = purchasedLottosDto.getLottos().stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(PURCHASED_LOTTO_NUMBERS_DELIMITER, PURCHASED_LOTTO_PREFIX, PURCHASED_LOTTO_SUFFIX)))
                .collect(Collectors.joining(PURCHASED_LOTTOS_DELIMITER));
        System.out.println(result);
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

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
