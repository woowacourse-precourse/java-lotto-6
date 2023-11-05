package lotto.application.input;

import static lotto.resource.TextResourceProvider.ERROR_MESSAGE_TAG;
import static lotto.resource.TextResourceProvider.INPUT_BONUS_NUMBER_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_PURCHASE_AMOUNT_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_WINNING_NUMBERS_TEXT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.regex.Pattern;
import java.util.stream.Stream;
import lotto.MyApplicationTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Application] 구입금액에 대한 테스트")
public class Application_PurchaseAmountTest extends MyApplicationTest {
    private static final Pattern ErrorMessagePattern = Pattern.compile(
            String.format("^\\%s", ERROR_MESSAGE_TAG));


    @Disabled
    @ParameterizedTest(name = "''{0}''을 입력했을 시 IllegalArgumentException이 발생한다")
    @MethodSource("getStringSourceCannotConvertToLong")
    void 로또_구입금액이_long_타입_정수가_아닐_시_IllegalArgumentException을_발생시킨다(String invalidInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    runWithInvalidPurchaseAmount(invalidInput);
                });
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 에러메시지 내용을 출력한다")
    @MethodSource("getStringSourceCannotConvertToLong")
    void 로또_구입금액이_long_타입_정수가_아닐_시_에러_메시지_내용을_출력한다(String invalidInput) {
        runWithInvalidPurchaseAmount(invalidInput);

        assertThatPrintErrorMessageWith(PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT);
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 어플리케이션이 예외 발생 후 종료되지 않는다")
    @MethodSource("getStringSourceCannotConvertToLong")
    void 로또_구입금액이_long_타입_정수가_아닐_시_예외_발생_후_종료되지_않는다(String invalidInput) {
        runWithInvalidPurchaseAmount(invalidInput);

        assertThatApplicationNotExists();
    }

    @Disabled
    @ParameterizedTest(name = "''{0}''을 입력했을 시 IllegalArgumentException이 발생한다")
    @MethodSource("getStringSourceIsNegativeLong")
    void 로또_구입금액이_음수일_때_IllegalArgumentException을_발생시킨다(String invalidInput) {
        assertThatIllegalArgumentException().
                isThrownBy(() -> {
                    runWithInvalidPurchaseAmount(invalidInput);
                });
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 에러메시지 내용을 출력한다")
    @MethodSource("getStringSourceIsNegativeLong")
    void 로또_구입금액이_음수일_때_에러_메시지_내용을_출력한다(String invalidInput) {
        runWithInvalidPurchaseAmount(invalidInput);

        assertThatPrintErrorMessageWith(PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT);
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 어플리케이션이 예외 발생 후 종료되지 않는다")
    @MethodSource("getStringSourceIsNegativeLong")
    void 로또_구입금액이_음수일_때_예외_발생_후_종료되지_않는다(String invalidInput) {
        runWithInvalidPurchaseAmount(invalidInput);

        assertThatApplicationNotExists();
    }

    @Disabled
    @ParameterizedTest(name = "''{0}''을 입력했을 시 IllegalArgumentException이 발생한다")
    @MethodSource("getStringSourceCannotDivideByUnit")
    void 로또_구입금액이_1000원으로_나누어_떨어지지_않는_경우_IllegalArgumentException을_발생시킨다(String invalidInput) {
        assertThatIllegalArgumentException().
                isThrownBy(() -> {
                    runWithInvalidPurchaseAmount(invalidInput);
                });
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 에러메시지 내용을 출력한다")
    @MethodSource("getStringSourceCannotDivideByUnit")
    void 로또_구입금액이_1000원으로_나누어_떨어지지_않는_경우_에러_메시지_내용을_출력한다(String invalidInput) {
        runWithInvalidPurchaseAmount(invalidInput);

        assertThatPrintErrorMessageWith(PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT);
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 어플리케이션이 예외 발생 후 종료되지 않는다")
    @MethodSource("getStringSourceCannotDivideByUnit")
    void 로또_구입금액이_1000원으로_나누어_떨어지지_않는_경우_예외_발생_후_종료되지_않는다(String invalidInput) {
        runWithInvalidPurchaseAmount(invalidInput);

        assertThatApplicationNotExists();
    }

    private static Stream<String> getStringSourceCannotConvertToLong() {
        return Stream.of("abcd", "123z1", "123 456", "123,456", "123456.0", "",
                "9223372036854775808",
                "-9,223,372,036,854,775,809");
    }

    private static Stream<String> getStringSourceIsNegativeLong() {
        return Stream.of("-1", "-1000");
    }

    private static Stream<String> getStringSourceCannotDivideByUnit() {
        return Stream.of("1001", "999", "0");
    }

    private static void runWithInvalidPurchaseAmount(String invalidInput) {
        run(invalidInput, "1000", "123456", "7");
    }

    private static void assertThatPrintErrorMessageWith(String message) {
        assertThat(outputs())
                .filteredOn(output -> ErrorMessagePattern.matcher(output).find())
                .hasSize(1)
                .first()
                .asString()
                .contains(message);
    }

    private static void assertThatApplicationNotExists() {
        assertThat(outputs())
                .containsSubsequence(INPUT_PURCHASE_AMOUNT_TEXT,
                        INPUT_WINNING_NUMBERS_TEXT,
                        INPUT_BONUS_NUMBER_TEXT,
                        OUTPUT_LOTTERY_RESULT);
    }
}
