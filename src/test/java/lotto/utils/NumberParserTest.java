package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.PurchaseAmount;
import lotto.view.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberParserTest {

    @Test
    @DisplayName("앞, 뒤 공백이 있는 경우 공백을 다듬어 객체를 생성한다")
    void removeTrim() {
        //given
        String input = "  1000   ";

        //when
        PurchaseAmount purchaseAmount = NumberParser.parsePurchaseAmount(input);

        //then
        assertEquals(purchaseAmount.getPurchaseAmount(), 1000);
    }

    @Test
    @DisplayName("입력 값이 정수가 아니면 예외를 발생")
    void throwExceptionIfInputNotInteger() {
        // given
        String input = "money";

        // when
        // then
        assertThatThrownBy(() -> NumberParser.parsePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값이 빈칸이면 예외를 발생")
    void throwExceptionIfInputIsEmpty() {
        // given
        String input = "";

        // when
        // then
        assertThatThrownBy(() -> NumberParser.parsePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_BLANK_EXCEPTION.getErrorMessage());
    }

    @Test
    @DisplayName("입력 값이 공백이면 예외를 발생")
    void throwExceptionIfInputIsBlank() {
        // given
        String input = " ";

        // when
        // then
        assertThatThrownBy(() -> NumberParser.parsePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_BLANK_EXCEPTION.getErrorMessage());
    }

    @Test
    @DisplayName("입력 값이 null이면 예외를 발생")
    void throwExceptionIfInputIsNull() {
        // given
        String input = null;

        // when
        // then
        assertThatThrownBy(() -> NumberParser.parsePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_BLANK_EXCEPTION.getErrorMessage());
    }
}