package lotto.controller.dto.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseAmountDtoTest {
    @Nested
    class 로또구입금액_입력값_생성시 {

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
        void 유효한_입력길이가_아니라면_예외가_발생한다(String amount) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> new LottoPurchaseAmountDto(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력 길이");
        }

        @EmptySource
        @ParameterizedTest
        void 공백만_있다면_예외가_발생한다(String amount) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> new LottoPurchaseAmountDto(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("공백");
        }

        @ValueSource(strings = {"1003as", "sd334", "asdf"})
        @ParameterizedTest
        void 숫자이외문자가_있다면_예외가_발생한다(String amount) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> new LottoPurchaseAmountDto(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자");
        }
    }

    @Nested
    class int로_변환시 {

        @CsvSource({"1000, 1000",
                "100000000, 100000000",
                "123000, 123000"})
        @ParameterizedTest
        void 성공한다(String amount, int expected) {
            //given
            LottoPurchaseAmountDto lottoPurchaseAmountDto = new LottoPurchaseAmountDto(amount);
            //when
            int lottoPurchaseAmount = lottoPurchaseAmountDto.toInt();
            // then
            assertThat(lottoPurchaseAmount).isEqualTo(expected);
        }
    }
}