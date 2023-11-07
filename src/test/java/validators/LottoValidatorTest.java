package validators;

import constants.ErrorCodeConstant;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoValidatorTest {

    @DisplayName("공백 입력할 경우 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {""," ","2,,3,4",",,,",","})
    void isBlankInputLottoExceptionTest(String inputLotto) {
        // given: parameter

        //when
        Throwable thrown = Assertions.catchThrowable(() -> {
            LottoValidator.verifyInputLotto(inputLotto);
        });

        // then
        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCodeConstant.STRING_BLANK_ERROR);
    }

    @DisplayName("숫자/콤마 외의 문자가 있을 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {" ,","2, ","2 ,","2, 4, 5","2, , ,3,4"})
    void isNumberAndCommaExceptionTest(String inputLotto) {
        // given: parameter

        //when
        Throwable thrown = Assertions.catchThrowable(() -> {
            LottoValidator.verifyInputLotto(inputLotto);
        });

        // then
        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCodeConstant.NUMBER_AND_COMMA_VALIDATION_ERROR);
    }

    @DisplayName("로또 당첨 번호가 6개 이상일 경우 예외 발생")
    @Test
    void isLottoNumberLengthTest() {
        // given
        List<Integer> numbers = List.of(1,2,3,4,5,6,7);

        //when
        Throwable thrown = Assertions.catchThrowable(() -> {
            LottoValidator.verifyLotto(numbers);
        });

        // then
        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCodeConstant.DEFAULT_LOTTO_NUMBER_LENGTH_ERROR);
    }


    @DisplayName("로또 당첨 번호가 하나라도 1 ~ 45 사이가 아닐 경우 예외 발생")
    @Test
    void isBetweenLottoNumberTest() {
        // given
        List<Integer> numbers = List.of(0,46,50,100,33,44);

        //when
        Throwable thrown = Assertions.catchThrowable(() -> {
            LottoValidator.verifyLotto(numbers);
        });

        // then
        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCodeConstant.BETWEEN_LOTTO_NUMBER_ERROR);
    }

}
