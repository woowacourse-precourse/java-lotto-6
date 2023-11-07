package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.EnumSource.Mode.INCLUDE;

import lotto.TestDefault;
import lotto.constants.PrintMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

class ConsolePrinterTest extends TestDefault {
    @DisplayName("PrintMessages에 있는 일반적인 문자열들이 정상적으로 출력 된다.")
    @ParameterizedTest
    @EnumSource(mode = INCLUDE, names = {
            "PROMPT_LOTTO_PURCHASE_AMOUNT",
            "PROMPT_WINNING_NUMBERS",
            "PROMPT_WINNING_BONUS_NUMBER",
            "WINNING_STATICS_TOP_BANNER",
    })
    void testShowGeneralMessage(PrintMessages message) {
        ConsolePrinter.showMessage(message);

        assertThat(getConsoleOuputMessage())
                .isEqualTo(message.getMessage());
    }

    @DisplayName("출력할 메시지가 null일 경우 예외 처리가 발생한다.")
    @ParameterizedTest
    @NullSource
    void testShowGeneralMessageNullCheck(PrintMessages message) {
        assertThatThrownBy(() -> {
            ConsolePrinter.showMessage(message);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}