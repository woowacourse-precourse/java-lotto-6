package lotto.application.input;

import static lotto.resource.TextResourceProvider.BONUS_NUMBER_CANNOT_CONVERT_TO_INTEGER_TEXT;
import static lotto.resource.TextResourceProvider.BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45_TEXT;
import static lotto.resource.TextResourceProvider.BONUS_NUMBER_SHOULD_NOT_IN_WINNING_NUMBERS_TEXT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Application_BonusNumberTest extends Application_InputTest {
    @Disabled
    @ParameterizedTest(name = "''{0}''을 입력했을 시 IllegalArgumentException이 발생한다")
    @MethodSource("getStringCanNotConvertToInteger")
    void 입력이_정수형_타입으로_변환할_수_없으면_IllegalArgumentException을_발생시킨다(String invalidInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    runWithInvalidInput(invalidInput);
                });
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 에러메시지 내용을 출력한다")
    @MethodSource("getStringCanNotConvertToInteger")
    void 입력이_정수형_타입으로_변환할_수_없으면_에러_메시지_내용을_출력한다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatPrintErrorMessageWith(BONUS_NUMBER_CANNOT_CONVERT_TO_INTEGER_TEXT);
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 어플리케이션이 예외 발생 후 종료되지 않는다")
    @MethodSource("getStringCanNotConvertToInteger")
    void 입력이_정수형_타입으로_변환할_수_없으면_예외_발생_후_종료되지_않는다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatApplicationNotExists();
    }

    @Disabled
    @ParameterizedTest(name = "''{0}''을 입력했을 시 IllegalArgumentException이 발생한다")
    @MethodSource("getStringNotBetween1TO45")
    void 보너스번호가_1부터_45_사이의_숫자가_아니라면_IllegalArgumentException을_발생시킨다(String invalidInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    runWithInvalidInput(invalidInput);
                });
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 에러메시지 내용을 출력한다")
    @MethodSource("getStringNotBetween1TO45")
    void 보너스번호가_1부터_45_사이의_숫자가_아니라면_에러_메시지_내용을_출력한다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatPrintErrorMessageWith(BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45_TEXT);
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 어플리케이션이 예외 발생 후 종료되지 않는다")
    @MethodSource("getStringNotBetween1TO45")
    void 보너스번호가_1부터_45_사이의_숫자가_아니라면_예외_발생_후_종료되지_않는다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatApplicationNotExists();
    }

    @Disabled
    @ParameterizedTest(name = "''{0}''을 입력했을 시 IllegalArgumentException이 발생한다")
    @MethodSource("getBonusNumberIsInWinningNumber")
    void 보너스_번호가_당첨_번호에_있으면_IllegalArgumentException을_발생시킨다(String invalidInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    runWithInvalidInput(invalidInput);
                });
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 에러메시지 내용을 출력한다")
    @MethodSource("getBonusNumberIsInWinningNumber")
    void 보너스_번호가_당첨_번호에_있으면_에러_메시지_내용을_출력한다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatPrintErrorMessageWith(BONUS_NUMBER_SHOULD_NOT_IN_WINNING_NUMBERS_TEXT);
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 어플리케이션이 예외 발생 후 종료되지 않는다")
    @MethodSource("getBonusNumberIsInWinningNumber")
    void 보너스_번호가_당첨_번호에_있으면_예외_발생_후_종료되지_않는다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatApplicationNotExists();
    }

    private static Stream<String> getStringCanNotConvertToInteger() {
        return Stream.of("a", "6.01", "2147483648", "-2147483649");
    }

    private static Stream<String> getStringNotBetween1TO45() {
        return Stream.of("0", "46");
    }

    private static Stream<String> getBonusNumberIsInWinningNumber() {
        return Stream.of("1", "6");
    }

    private static void runWithInvalidInput(String invalidInput) {
        run("1000", "1,2,3,4,5,6", invalidInput, "7");
    }
}
