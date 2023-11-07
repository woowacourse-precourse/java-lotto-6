package lotto.ui;

import static lotto.ui.UIMessage.BONUS_NUMBER_MUST_BE_INTEGER;
import static lotto.ui.UIMessage.INSERT_ANSWER_NUMBER;
import static lotto.ui.UIMessage.INSERT_BONUS_NUMBER;
import static lotto.ui.UIMessage.INSERT_PAYMENT_PRICE;
import static lotto.ui.UIMessage.PAYMENT_PRICE_MUST_BE_INTEGER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public final class InputView extends ConsoleWriter {
    private Function<String, Integer> convertStringToInteger(String input) {
        return (errorMessage) -> {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ignore) {
                throw new IllegalArgumentException(errorMessage);
            }
        };
    }

    public int readPaymentPrice() {
        INSERT_PAYMENT_PRICE.accept(this::println);
        return PAYMENT_PRICE_MUST_BE_INTEGER.apply(convertStringToInteger(Console.readLine()));
    }

    public List<Integer> readAnswerNumber() {
        INSERT_ANSWER_NUMBER.accept(this::newLineAndPrintln);

        final var input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(this::convertStringToInteger)
                .map(INSERT_BONUS_NUMBER::apply)
                .toList();

    }

    public int readBonusNumber() {
        INSERT_BONUS_NUMBER.accept(this::newLineAndPrintln);
        return BONUS_NUMBER_MUST_BE_INTEGER.apply(convertStringToInteger(Console.readLine()));
    }
}
