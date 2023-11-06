package lotto.application.input;

import static lotto.resource.TextResourceProvider.INPUT_WINNING_NUMBERS_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT;
import static lotto.resource.TextResourceProvider.WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS_TEXT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Application] 당첨번호에 대한 테스트")
public class Application_WinningNumbersTest extends Application_InputTest {
    @Disabled
    @ParameterizedTest(name = "''{0}''을 입력했을 시 IllegalArgumentException이 발생한다")
    @MethodSource("getStringDoNotSeparatedByDelimiter")
    void 구분자로_구분될_수_없는_문자열인_경우_IllegalArgumentException을_발생시킨다(String invalidInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    runWithInvalidInput(invalidInput);
                });

    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 에러메시지 내용을 출력한다")
    @MethodSource("getStringDoNotSeparatedByDelimiter")
    void 구분자로_구분될_수_없는_문자열인_경우_에러_메시지_내용을_출력한다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatPrintErrorMessageWith(WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT);
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 어플리케이션이 예외 발생 후 종료되지 않는다")
    @MethodSource("getStringDoNotSeparatedByDelimiter")
    void 구분자로_구분될_수_없는_문자열인_경우_예외_발생_후_종료되지_않는다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatApplicationNotExists();
    }

    @Disabled
    @ParameterizedTest(name = "''{0}''을 입력했을 시 IllegalArgumentException이 발생한다")
    @MethodSource("getStringCannotConvertToInteger")
    void 문자열의_토큰이_정수형_타입으로_변환할_수_없으면_IllegalArgumentException을_발생시킨다(String invalidInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    runWithInvalidInput(invalidInput);
                });

    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 에러메시지 내용을 출력한다")
    @MethodSource("getStringCannotConvertToInteger")
    void 문자열의_토큰이_정수형_타입으로_변환할_수_없으면_에러_메시지_내용을_출력한다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatPrintErrorMessageWith(WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT);
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 어플리케이션이 예외 발생 후 종료되지 않는다")
    @MethodSource("getStringCannotConvertToInteger")
    void 문자열의_토큰이_정수형_타입으로_변환할_수_없으면_예외_발생_후_종료되지_않는다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatApplicationNotExists();
    }

    @Disabled
    @ParameterizedTest(name = "''{0}''을 입력했을 시 IllegalArgumentException이 발생한다")
    @MethodSource("getStringNotBetween1TO45")
    void 각_당첨번호의_숫자는_1부터_45사이의_숫자가_아니면_IllegalArgumentException을_발생시킨다(String invalidInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    runWithInvalidInput(invalidInput);
                });

    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 에러메시지 내용을 출력한다")
    @MethodSource("getStringNotBetween1TO45")
    void 각_당첨번호의_숫자는_1부터_45사이의_숫자가_아니면_에러_메시지_내용을_출력한다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatPrintErrorMessageWith(WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45_TEXT);
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 어플리케이션이 예외 발생 후 종료되지 않는다")
    @MethodSource("getStringNotBetween1TO45")
    void 각_당첨번호의_숫자는_1부터_45사이의_숫자가_아니면_예외_발생_후_종료되지_않는다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatApplicationNotExists();
    }

    @Disabled
    @ParameterizedTest(name = "''{0}''을 입력했을 시 IllegalArgumentException이 발생한다")
    @MethodSource("getStringIsNot6UniqueNumber")
    void 당첨번호가_중복되지_않는_6개의_숫자가_아니라면_IllegalArgumentException을_발생시킨다(String invalidInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    runWithInvalidInput(invalidInput);
                });

    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 에러메시지 내용을 출력한다")
    @MethodSource("getStringIsNot6UniqueNumber")
    void 당첨번호가_중복되지_않는_6개의_숫자가_아니라면_에러_메시지_내용을_출력한다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatPrintErrorMessageWith(WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS_TEXT);
    }

    @ParameterizedTest(name = "''{0}''을 입력했을 시 어플리케이션이 예외 발생 후 종료되지 않는다")
    @MethodSource("getStringIsNot6UniqueNumber")
    void 당첨번호가_중복되지_않는_6개의_숫자가_아니라면_예외_발생_후_종료되지_않는다(String invalidInput) {
        runWithInvalidInput(invalidInput);

        assertThatApplicationNotExists();
    }

    private static Stream<String> getStringDoNotSeparatedByDelimiter() {
        return Stream.of("1 2 3 4 5 6", "1;2;3;4;5;6", "1:2:3:4:5:6");
    }

    private static Stream<String> getStringCannotConvertToInteger() {
        return Stream.of("1,2,3,4,5,z", "1,2,,3,4,5,6", "1,2,3,4,5,6.0", "1,2,3,4,5,2147483648",
                "1,2,3,4,5,-2147483649");
    }

    private static Stream<String> getStringNotBetween1TO45() {
        return Stream.of("0,1,2,3,4,5", "1,2,3,4,5,46");
    }

    private static Stream<String> getStringIsNot6UniqueNumber() {
        return Stream.of("1,1,2,3,4,5", "1,2,3,4,5,6,7");
    }

    private static void runWithInvalidInput(String invalidInput) {
        run("1000", invalidInput, "1,2,3,4,5,6", "7");
    }

    private static String getWinningNumbersInput() {
        int index = outputs().indexOf(INPUT_WINNING_NUMBERS_TEXT);
        return outputs().get(index + 1);
    }
}
