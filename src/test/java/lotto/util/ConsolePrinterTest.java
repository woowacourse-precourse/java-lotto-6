package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.params.provider.EnumSource.Mode.INCLUDE;

import java.util.List;
import lotto.TestDefault;
import lotto.constants.DomainMessages;
import lotto.constants.ErrorMessages;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConsolePrinterTest extends TestDefault {
    @DisplayName("일반적인 문자열들이 정상적으로 출력 된다.")
    @ParameterizedTest
    @EnumSource(mode = INCLUDE, names = {
            "PROMPT_LOTTO_PURCHASE_AMOUNT",
            "PROMPT_WINNING_NUMBERS",
            "PROMPT_WINNING_BONUS_NUMBER",
            "WINNING_STATICS_TOP_BANNER",
    })
    void testShowGeneralMessage(DomainMessages message) {
        String excepted = message.getMessage();

        ConsolePrinter.showMessage(message);

        assertThat(getConsoleOuputMessage())
                .isEqualTo(excepted);
    }

    @DisplayName("출력할 메시지가 null일 경우 예외 처리가 발생한다.")
    @ParameterizedTest
    @NullSource
    void testShowGeneralMessageNullExceptionCheck(DomainMessages message) {
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
    void testShowMessageWithNumber(DomainMessages message) {
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
    void testShowMessageWithNumberNullExceptionCheck(DomainMessages message) {
        assertThatNullPointerException().isThrownBy(() -> {
            ConsolePrinter.showMessageWithNumber(message, null);
        });
    }

    @DisplayName("한개의 숫자(int형)가 포함된 문자열 출력시 메시지가 null 일경우 예외처리가 발생한다.")
    @ParameterizedTest
    @NullSource
    void testShowMessageWithNumberMessageNullExceptionCheck(DomainMessages message) {
        assertThatNullPointerException().isThrownBy(() -> {
            ConsolePrinter.showMessageWithNumber(message, 1);
        });
    }

    @DisplayName("로또 번호 6자리가 정상적으로 출력된다.")
    @Test
    void testShowLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        ConsolePrinter.showLottoNumbers(lotto);

        assertThat(getConsoleOuputMessage())
                .isEqualTo(DomainMessages.LOTTO_NUMBERS.getMessageWithLotto(lotto));
    }

    @DisplayName("로또 번호 출력시 null을 전달할 경우 예외가 발생한다.")
    @Test
    void testShowLottoNumbersNullExceptionCheck() {
        Lotto lotto = null;

        assertThatNullPointerException().isThrownBy(() -> {
            ConsolePrinter.showLottoNumbers(lotto);
        });
    }

    @DisplayName("로또 번호 출력시 번호 개수가 다를 경우 예외가 발생한다.")
    @Test
    void testShowLottoNumbersLengthExceptionCheck() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3));
            ConsolePrinter.showLottoNumbers(lotto);
        });
    }

    @DisplayName("총 수익률이 정상적으로 출력된다.")
    @ParameterizedTest
    @ValueSource(doubles = {5, 5.50, 5.53, 5.54, 5.55, 5.56, 0, -0.1, -1, -5.5})
    void testShowTotalReturn(Double totalReturn) {
        ConsolePrinter.showTotalReturn(totalReturn);

        assertThat(getConsoleOuputMessage())
                .isEqualTo(DomainMessages.TOTAL_RETURN.getMessageWithTotalReturn(totalReturn));
    }

    @DisplayName("총 수익률 출력시 수익률이 null일 경우 예외처리가 발생한다.")
    @ParameterizedTest
    @NullSource
    void testShowTotalReturnNullExceptionCheck(Double totalReturn) {
        assertThatNullPointerException().isThrownBy(() -> {
            ConsolePrinter.showTotalReturn(totalReturn);
        });
    }

    @DisplayName("에러 메시지가 정상적으로 출력된다.")
    @ParameterizedTest
    @EnumSource(ErrorMessages.class)
    void testShowException(ErrorMessages message) {
        String expectedMessage = message.getMessage();

        ConsolePrinter.showException(message);

        assertThat(getConsoleOuputMessage()).isEqualTo(expectedMessage);
    }

    @DisplayName("출력할 에러 메시지가 null일 경우 예외 처리가 발생한다.")
    @ParameterizedTest
    @NullSource
    void testShowExceptionMessageNullExceptionCheck(ErrorMessages message) {
        assertThatNullPointerException().isThrownBy(() -> {
            ConsolePrinter.showException(message);
        });
    }

    @DisplayName("에러 메시지 타이틀은 '[ERROR]' 이다.")
    @ParameterizedTest
    @EnumSource(ErrorMessages.class)
    void testShowExceptionTitleCheck(ErrorMessages message) {
        String expected = "[ERROR]";

        ConsolePrinter.showException(message);
        String actualed = getConsoleOuputMessage().substring(0, 7);

        assertThat(actualed).isEqualTo(expected);
    }

    @DisplayName("한개 이상의 숫자(int형)가 포함된 에러들이 정상적으로 출력된다.")
    @ParameterizedTest
    @EnumSource(mode = INCLUDE, names = {
            "LOTTO_PURCHASE_AMOUNT_UNIT",
            "LOTTO_NUMBERS_COUNT",
            "LOTTO_NUMBErS_RANGE",
            "WINNING_NUMBERS_COUNT",
            "WINNING_NUMBERS_RANGE",
            "BONUS_NUMBER_RANGE",
    })
    void testShowExceptionWithNumber(ErrorMessages message) {
        List<Integer> numbers = List.of(1, 2);
        String excepted = message.getMessage(numbers);

        ConsolePrinter.showException(message, numbers);

        assertThat(getConsoleOuputMessage()).isEqualTo(excepted);
    }
}