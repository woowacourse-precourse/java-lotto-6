package lotto.controller.dto.input;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseAmountDtoTest {
    @CsvSource({"1000, 1000",
            "100000000, 100000000",
            "123000, 123000"})
    @ParameterizedTest
    void int로_변환한다(String input, int expected) {
        //given
        LottoPurchaseAmountDto lottoPurchaseAmountDto = new LottoPurchaseAmountDto(input);
        //when
        int lottoPurchaseAmount = lottoPurchaseAmountDto.toInt();
        // then
        assertThat(lottoPurchaseAmount).isEqualTo(expected);
    }

    @Nested
    class 로또구입금액_입력값객체_생성시 {

        @Test
        void 성공적으로_생성한다() {
            //given
            String amount = "1200";
            //when
            LottoPurchaseAmountDto lottoPurchaseAmountDto = new LottoPurchaseAmountDto(amount);
            //then
            assertThat(lottoPurchaseAmountDto.purchaseAmount()).isEqualTo(amount);
        }

        @ValueSource(strings = {"1000000000", "10000000000"})
        @ParameterizedTest
        void 유효한_입력길이가_아니라면_예외가발생한다(String amount) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> new LottoPurchaseAmountDto(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputValidator.INVALID_LENGTH_INPUT_ERROR_MESSAGE);
        }

        @ValueSource(strings = {" ", "\n", "\r", "\r\n", "\t"})
        @ParameterizedTest
        void 공백만_있다면_예외가발생한다(String amount) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> new LottoPurchaseAmountDto(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputValidator.BLANK_INPUT_ERROR_MESSAGE);
        }

        @ValueSource(strings = {"1003as", "sd334", "asdf"})
        @ParameterizedTest
        void 숫자이외문자가_있다면_예외가발생한다(String amount) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> new LottoPurchaseAmountDto(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputValidator.INVALID_NUMERIC_INPUT_ERROR_MESSAGE);
        }
    }
}