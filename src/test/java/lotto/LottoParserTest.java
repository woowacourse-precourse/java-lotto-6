package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoParserTest {

    @DisplayName("공백이 있는 경우 공백을 다듬어 Lotto 객체를 생성한다")
    @Test
    void removeTrim() {
        //given
        String input = "  1,2,3,4,5,6   ";

        //when
        Lotto lotto = LottoParser.parseLotto(input);

        //then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("입력 값이 정수와 구분자 외에 다른 문자가 들어오면 예외를 발생")
    @Test
    void throwExceptionIfInputNotIntegerOrSeparate() {
        // given
        String input = "hello";

        // when
        // then
        assertThatThrownBy(() -> LottoParser.parseLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoParser.NOT_INTEGER_EXCEPTION);
    }

    @DisplayName("입력 값이 빈칸이면 예외를 발생")
    @Test
    void throwExceptionIfInputIsEmpty() {
        // given
        String input = "";

        // when
        // then
        Assertions.assertThatThrownBy(() -> LottoParser.parseLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NumberParser.INPUT_BLANK_EXCEPTION);
    }

    @DisplayName("입력 값이 공백이면 예외를 발생")
    @Test
    void throwExceptionIfInputIsBlank() {
        // given
        String input = " ";

        // when
        // then
        Assertions.assertThatThrownBy(() -> LottoParser.parseLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NumberParser.INPUT_BLANK_EXCEPTION);
    }

    @DisplayName("입력 값이 null이면 예외를 발생")
    @Test
    void throwExceptionIfInputIsNull() {
        // given
        String input = null;

        // when
        // then
        Assertions.assertThatThrownBy(() -> LottoParser.parseLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NumberParser.INPUT_BLANK_EXCEPTION);
    }

}