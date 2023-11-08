package lotto.controller.dto.input;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusBallDtoTest {
    @CsvSource({"1, 1",
            "45, 45"})
    @ParameterizedTest
    void int로_변환한다(String input, int expected) {
        //given
        BonusBallDto bonusBallDto = new BonusBallDto(input);
        //when
        int bonusBall = bonusBallDto.toInt();
        // then
        assertThat(bonusBall).isEqualTo(expected);
    }

    @Nested
    class 보너스볼_입력값객체_생성시 {

        @Test
        void 성공적으로_생성한다() {
            //given
            String bonusBall = "1";
            //when
            BonusBallDto bonusBallDto = new BonusBallDto(bonusBall);
            //then
            assertThat(bonusBallDto.bonusBall()).isEqualTo(bonusBall);
        }

        @ValueSource(strings = {"", "100"})
        @ParameterizedTest
        void 유효한_입력길이가_아니라면_예외가발생한다(String bonusBall) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> new BonusBallDto(bonusBall))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputValidator.INVALID_LENGTH_INPUT_ERROR_MESSAGE);
        }

        @ValueSource(strings = {" ", "\n", "\r", "\r\n", "\t"})
        @ParameterizedTest
        void 공백만_있다면_예외가발생한다(String bonusBall) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> new BonusBallDto(bonusBall))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputValidator.BLANK_INPUT_ERROR_MESSAGE);
        }

        @ValueSource(strings = {"as", "1a", "s1"})
        @ParameterizedTest
        void 숫자이외문자가_있다면_예외가발생한다(String bonusBall) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> new BonusBallDto(bonusBall))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputValidator.INVALID_NUMERIC_INPUT_ERROR_MESSAGE);
        }
    }
}