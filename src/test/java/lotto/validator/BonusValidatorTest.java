package lotto.validator;

import static lotto.view.message.ErrorMessage.DUPLICATED_NUMBER_IN_WINNING_LOTTO;
import static lotto.view.message.ErrorMessage.EMPTY_INPUT;
import static lotto.view.message.ErrorMessage.NOT_NUMBER;
import static lotto.view.message.ErrorMessage.NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class BonusValidatorTest {
    private final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 보너스_번호_빈_입력_예외_처리() {
        String input = "";
        assertThatThrownBy(() -> BonusValidator.validate(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_INPUT.getErrorMessage());
    }

    @Test
    void 보너스_번호_숫자가_아닌_문자가_포함된_입력_예외_처리() {
        String input = "3o";

        assertThatThrownBy(() -> BonusValidator.validate(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER.getErrorMessage());
    }

    @Test
    void 보너스_번호_1과_45_사이의_숫자가_아닌_입력_예외_처리() {
        String input = "0";
        assertThatThrownBy(() -> BonusValidator.validate(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE.getErrorMessage());
    }

    @Test
    void 보너스_번호_중복된_숫자가_당첨_번호에_있는_입력_예외_처리() {
        String input = "2";
        assertThatThrownBy(() -> BonusValidator.validate(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NUMBER_IN_WINNING_LOTTO.getErrorMessage());
    }
}