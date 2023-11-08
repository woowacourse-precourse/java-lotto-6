package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputValidatorTest {
    private final static InputValidator lottoInputValidator = new LottoInputValidator();

    @DisplayName("당첨 번호 입력 개수가 6개가 넘어갈 경우 예외가 발생한다.")
    @Test
    void inputWinningNumberOverBySize() {
        //given
        String values = "1,2,3,4,5,6,7";

        //when,then
        Assertions.assertThatThrownBy(() -> lottoInputValidator.validate(values))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.LOTTO_LENGTH_NOT_SIX_MESSAGE.getMessage());
    }

    @DisplayName("당첨 번호 입력 개수가 6개 미만일 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersUnderBySize() {
        //given
        String values = "1,2,3,4,5";

        //when,then
        Assertions.assertThatThrownBy(() -> lottoInputValidator.validate(values))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.LOTTO_LENGTH_NOT_SIX_MESSAGE.getMessage());
    }

    @DisplayName("당첨 번호에 숫자 이외의 값이 들어가있을 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersNotNumber() {
        //given
        String values = "1,w,2,3,4,5";

        //when,then
        Assertions.assertThatThrownBy(() -> lottoInputValidator.validate(values))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.LOTTO_NUMBER_IS_NOT_NUMERIC.getMessage());
    }
}