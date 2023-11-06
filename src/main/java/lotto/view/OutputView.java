package lotto.view;

import lotto.dto.FinalResultResponse;
import lotto.dto.LottoNumberResponse;
import lotto.dto.LottoNumberResponses;
import lotto.view.constants.PrintMessage;

import static lotto.view.constants.PrintMessage.*;

public class OutputView {
    public static void printMessage(final PrintMessage message) {
        println(message.getMessage());
    }

    public static void println(final Object data) {
        System.out.println(data);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printPurchaseLottoNumbers(final LottoNumberResponses responses) {
        responses.lottoResponses()
                .stream()
                .map(LottoNumberResponse::numbers)
                .forEach(OutputView::println);

        printNewLine();
    }

    public static void printPurchaseCount(final LottoNumberResponses responses) {
        String formattedMessage = String.format(RESPONSE_PURCHASE_COUNT.getMessage(), responses.purchaseCount());
        println(formattedMessage);
    }

    public static void printFinalResult(final FinalResultResponse response) {
        printNewLine();
        printMessage(RESPONSE_PRIZE_STATISTICS);
        printMessage(RESPONSE_SEPARATOR);

        String formattedYieldMessage = String.format(RESPONSE_YIELD.getMessage(), response.convertYieldToString());
        println(formattedYieldMessage);
    }
}
