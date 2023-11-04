package lotto.view;

import lotto.dto.LottoResponses;
import lotto.exception.ErrorMessage;
import lotto.view.constants.PrintMessage;
import lotto.view.constants.PrintSymbol;

import java.text.Format;
import java.util.stream.Collectors;

import static lotto.view.constants.PrintMessage.*;
import static lotto.view.constants.PrintMessage.RESPONSE_PURCHASE_COUNT;

public class OutputView {
    public static void printMessage(final PrintMessage message) {
        println(message.getMessage());
    }

    public static void printError(final ErrorMessage message) {
        println(message.getMessage());
    }

    public static void printf(final String format, Object... objs) {
        System.out.printf(format, objs);
    }

    public static void println(final Object data) {
        System.out.println(data);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printPurchaseStatus(final LottoResponses responses) {
        String formattedMessage = String.format(RESPONSE_PURCHASE_COUNT.getMessage(), responses.purchaseCount());

        printNewLine();
        println(formattedMessage);

        responses.lottoResponses()
                .stream()
                .map(response -> String.format(RESPONSE_LOTTO_RESULT.getMessage(), response))
                .forEach(System.out::println);
    }
}
