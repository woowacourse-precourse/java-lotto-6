package lotto.domain;


import java.util.List;
import lotto.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAnswerValidatorTest {
    @DisplayName("당첨번호가 유요한지 확인하는 테스트 코드- 정상 동작")
    @Test
    void checkIsValidLottoNumbersCorrectTest() {
        //정상 동작
        Assertions.assertThat(LottoAnswerValidator.checkIsValidLottoNumbers("1,2,3,4,5,6"))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨번호가 유효한지 확인하는 테스트 코드 - 예외 발생")
    @Test
    void checkIsValidLottoNumbersExceptionTest(){
        //숫자가 아닌경우
        Assertions.assertThatThrownBy(() -> LottoAnswerValidator.checkIsValidLottoNumbers("가,나,다,라,마,바"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.CAN_NOT_CONVERT_TO_NUMBER.getMessage());

        //6개가 아닌 경우
        Assertions.assertThatThrownBy(() -> LottoAnswerValidator.checkIsValidLottoNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessages.NOT_SIX_NUMBERS.getMessage());

        //중복되는 수가 있는 경우
        Assertions.assertThatThrownBy(() -> LottoAnswerValidator.checkIsValidLottoNumbers("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.THERE_ARE_DUPLICATE_VALUES.getMessage());

    }

    @DisplayName("입력받은 수가 1 ~ 45 사이의 값이 아닌 경우 에러 발생")
    @Test
    void checkIsOnSideTest() {
        Assertions.assertThatThrownBy(() -> LottoAnswerValidator.checkIsOnSide(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.FALL_OUTSIDE_THE_RIGHT_RANGE.getMessage());
    }
}