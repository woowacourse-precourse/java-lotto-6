package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// 객체 생성시 발생하는 예외처리는 각 객체의 테스트 코드에서 진행하였습니다.
class ConsoleInputParserTest {

    @DisplayName("로또 구입 금액이 정수가 아닐 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1b", "1.1"})
    void parseNotIntegerInputToPurchaseAmount(String input) {
        // given
        ConsoleInputParser consoleInputParser = new ConsoleInputParser();
        // when, then
        assertThatThrownBy(() -> consoleInputParser.toPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER_INPUT.getWithPrefix());
    }

    @DisplayName("쉼표를 구분자로 입력을 나눴을 때, 나눠진 값들이 정수가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1,2,3,4,5,a", "1.1,2,3,4,5,6"})
    void parseNotIntegerInputToLotto(String input) {
        // given
        ConsoleInputParser consoleInputParser = new ConsoleInputParser();
        // when, then
        assertThatThrownBy(() -> consoleInputParser.toLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER_INPUT.getWithPrefix());
    }

    @DisplayName("쉼표를 구분자로 입력을 나눴을 때, 나눠진 값들이 공백을 포함해도 문제 없이 로또로 파싱한다.")
    @Test
    void parseIntegerInputWithBlankToLotto() {
        // given
        String input = " 1,  2 , 3,4,   5,   6 ";
        ConsoleInputParser consoleInputParser = new ConsoleInputParser();
        // when, then
        assertThatCode(() -> consoleInputParser.toLotto(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 정수가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1b", "1.1"})
    void parseNotIntegerToBounsNumber(String input) {
        // given
        ConsoleInputParser consoleInputParser = new ConsoleInputParser();
        Lotto winninglotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when, then
        assertThatThrownBy(() -> consoleInputParser.toBounsNumber(input, winninglotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER_INPUT.getWithPrefix());
    }
}