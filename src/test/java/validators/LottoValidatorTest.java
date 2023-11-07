package validators;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
            LottoValidator.isVerifyInputLotto(inputLotto);
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
            LottoValidator.isVerifyInputLotto(inputLotto);
        });

        // then
        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCodeConstant.NUMBER_AND_COMMA_VALIDATION_ERROR);
    }


    @DisplayName("로또 당첨 번호가 1 ~ 45 사이일 경우 true, 아니면 false")
    @Test
    void isBetweenLottoNumberTest() {
        // given
        List<Integer> numbers1 = List.of(1,12,22,33,44,45);
        List<Integer> numbers2 = List.of(0,46,50);

        //when
        boolean trueResult = LottoValidator.isVerifyLotto(numbers1);
        boolean falseResult = LottoValidator.isVerifyLotto(numbers2);

        //then
        assertThat(trueResult).isTrue();
        assertThat(falseResult).isFalse();
    }

}
