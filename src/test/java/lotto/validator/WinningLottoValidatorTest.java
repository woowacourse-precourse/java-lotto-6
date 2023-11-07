package lotto.validator;

import static lotto.view.message.ErrorMessage.DUPLICATED_NUMBER;
import static lotto.view.message.ErrorMessage.EMPTY_INPUT;
import static lotto.view.message.ErrorMessage.NOT_DEFAULT_LOTTO_SIZE;
import static lotto.view.message.ErrorMessage.NOT_NUMBER;
import static lotto.view.message.ErrorMessage.NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WinningLottoValidatorTest {
    @Test
    void 당첨_번호_빈_입력_예외_처리() {
        String input = "";

        assertThatThrownBy(() -> WinningLottoValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_INPUT.getErrorMessage());
    }

    @Test
    void 당첨_번호_숫자가_아닌_문자가_포함된_입력_예외_처리() {
        String input = "1,2,3,4,5,six";

        assertThatThrownBy(() -> WinningLottoValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER.getErrorMessage());
    }

    @Test
    void 당첨_번호_1과_45_사이의_숫자가_아닌_입력_예외_처리() {
        String input = "1,2,3,4,5,46";

        assertThatThrownBy(() -> WinningLottoValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE.getErrorMessage());
    }

    @Test
    void 당첨_번호_숫자의_개수가_6개가_아닌_입력_예외_처리() {
        String input = "1,2,3,4,5,6,7";

        assertThatThrownBy(() -> WinningLottoValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_DEFAULT_LOTTO_SIZE.getErrorMessage());
    }

    @Test
    void 당첨_번호_중복된_숫자가_있는_입력_예외_처리() {
        String input = "2,2,3,4,5,6";

        assertThatThrownBy(() -> WinningLottoValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NUMBER.getErrorMessage());
    }
}