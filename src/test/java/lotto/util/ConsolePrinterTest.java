package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.params.provider.EnumSource.Mode.INCLUDE;

import lotto.TestDefault;
import lotto.constants.PrintMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

class ConsolePrinterTest extends TestDefault {
    @DisplayName("일반적인 문자열들이 정상적으로 출력 된다.")
    @ParameterizedTest
    @EnumSource(mode = INCLUDE, names = {
            "PROMPT_LOTTO_PURCHASE_AMOUNT",
            "PROMPT_WINNING_NUMBERS",
            "PROMPT_WINNING_BONUS_NUMBER",
            "WINNING_STATICS_TOP_BANNER",
    })
    void testShowGeneralMessage(PrintMessages message) {
        String excepted = message.getMessage();

        ConsolePrinter.showMessage(message);

        assertThat(getConsoleOuputMessage())
                .isEqualTo(excepted);
    }

    @DisplayName("출력할 메시지가 null일 경우 예외 처리가 발생한다.")
    @ParameterizedTest
    @NullSource
    void testShowGeneralMessageNullCheck(PrintMessages message) {
        assertThatNullPointerException().isThrownBy(() -> {
            ConsolePrinter.showMessage(message);
        });
    }

    @DisplayName("한개의 숫자(int형)가 포함된 문자열들이 정상적으로 출력된다.")
    @ParameterizedTest
    @EnumSource(mode = INCLUDE, names = {
            "LOTTO_PURCHASE_COUNT",
            "FIFTH_PLACE_MESSAGE",
            "FOURTH_PLACE_MESSAGE",
            "THIRD_PLACE_MESSAGE",
            "SECOND_PLACE_MESSAGE",
            "FIRST_PLACE_MESSAGE",
    })
    void testShowMessageWithNumber(PrintMessages message) {
        Integer expectedNumberInMessage = 1;
        String excepted = message.getMessageWithNumber(expectedNumberInMessage);

        ConsolePrinter.showMessageWithNumber(message, expectedNumberInMessage);

        assertThat(getConsoleOuputMessage()).isEqualTo(excepted);
    }

    @DisplayName("한개의 숫자(int형)가 포함된 문자열 출력시 숫자가 null 일경우 예외처리가 발생한다.")
    @ParameterizedTest
    @EnumSource(mode = INCLUDE, names = {
            "LOTTO_PURCHASE_COUNT",
            "FIFTH_PLACE_MESSAGE",
            "FOURTH_PLACE_MESSAGE",
            "THIRD_PLACE_MESSAGE",
            "SECOND_PLACE_MESSAGE",
            "FIRST_PLACE_MESSAGE",
    })
    void testShowMessageWithNumberNullCheck(PrintMessages message) {
        assertThatNullPointerException().isThrownBy(() -> {
            ConsolePrinter.showMessageWithNumber(message, null);
        });
    }

    @DisplayName("한개의 숫자(int형)가 포함된 문자열 출력시 메시지가 null 일경우 예외처리가 발생한다.")
    @ParameterizedTest
    @NullSource
    void testShowMessageWithNumberMessageNullCheck(PrintMessages message) {
        assertThatNullPointerException().isThrownBy(() -> {
            ConsolePrinter.showMessageWithNumber(message, 1);
        });
    }
}