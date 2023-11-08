package lotto.controller.dto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.util.InputValidator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningTicketNumbersDtoTest {
    @Nested
    class 당첨로또번호_입력값객체_생성시 {

        @Test
        void 성공적으로_생성한다() {
            //given
            String numbers = "1,2,3,4,5,6";
            //when
            WinningLottoNumbersDto winningLottoNumbersDto = new WinningLottoNumbersDto(numbers);
            //then
            assertThat(winningLottoNumbersDto.winningLottoNumbers()).isEqualTo(numbers);
        }

        @ValueSource(strings = {"", "12,14,123,14,12,12,"})
        @ParameterizedTest
        void 유효한_입력길이가_아니라면_예외가발생한다(String numbers) {
            //given
            //when then
            assertThatThrownBy(() -> new WinningLottoNumbersDto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputValidator.INVALID_LENGTH_INPUT_ERROR_MESSAGE);
        }

        @ValueSource(strings = {" ", "\n", "\r", "\r\n", "\t"})
        @ParameterizedTest
        void 공백만_있다면_예외가발생한다(String numbers) {
            //given
            //when then
            assertThatThrownBy(() -> new WinningLottoNumbersDto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputValidator.BLANK_INPUT_ERROR_MESSAGE);
        }
    }

    @Nested
    class IntegerList로_변환시 {

        private static Stream<Arguments> getToIntegerListTestArgument() {
            return Stream.of(
                    Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                    Arguments.of("1,2,3,4,5,6,", List.of(1, 2, 3, 4, 5, 6))
            );
        }

        @MethodSource("getToIntegerListTestArgument")
        @ParameterizedTest
        void IntegerList로_변환한다(String input, List<Integer> expected) {
            //given
            WinningLottoNumbersDto winningLottoNumbersDto = new WinningLottoNumbersDto(input);
            //when
            List<Integer> winningLottoNumbers = winningLottoNumbersDto.toIntegerList();
            // then
            assertThat(winningLottoNumbers).isEqualTo(expected);
        }

        @ValueSource(strings = {"1a,2,4,5,7,8", "a,b,c,d,e,f"})
        @ParameterizedTest
        void 숫자와쉼표이외문자가_존재한다면_예외가발생한다(String input) {
            //given
            WinningLottoNumbersDto winningLottoNumbersDto = new WinningLottoNumbersDto(input);
            //when then
            assertThatThrownBy(winningLottoNumbersDto::toIntegerList)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputValidator.INVALID_NUMERIC_INPUT_ERROR_MESSAGE);
        }
    }
}