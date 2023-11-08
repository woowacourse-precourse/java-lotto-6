package lotto.application.input;

import static lotto.resource.TextResourceProvider.ERROR_MESSAGE_TAG;
import static lotto.resource.TextResourceProvider.INPUT_BONUS_NUMBER_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_PURCHASE_AMOUNT_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_WINNING_NUMBERS_TEXT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT_TEXT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;
import lotto.MyApplicationTest;

public class Application_InputTest extends MyApplicationTest {
    private static final Pattern ErrorMessagePattern = Pattern.compile(
            String.format("^\\%s", ERROR_MESSAGE_TAG));

    protected static void assertThatPrintErrorMessageWith(String message) {
        assertThat(outputs())
                .filteredOn(output -> ErrorMessagePattern.matcher(output).find())
                .hasSize(1)
                .first()
                .asString()
                .contains(message);
    }

    protected static void assertThatApplicationNotExists() {
        assertThat(outputs())
                .containsSubsequence(INPUT_PURCHASE_AMOUNT_TEXT,
                        INPUT_WINNING_NUMBERS_TEXT,
                        INPUT_BONUS_NUMBER_TEXT,
                        OUTPUT_LOTTERY_RESULT_TEXT);
    }
}

