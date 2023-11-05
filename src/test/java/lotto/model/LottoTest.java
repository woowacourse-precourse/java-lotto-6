package lotto.model;

import static lotto.Message.ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.LOTTO_IS_DUPLICATE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("model_Lotto_1_미만이_입력_했을_때")
    @Test
    public void model_Lotto_1_under_input() {
        String inputLotto = "0,2,3,4,5,6";

        assertThatThrownBy(() -> new Lotto(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Lotto_45_초과가_입력_했을_때")
    @Test
    public void model_Lotto_45_over_input() {
        String inputLotto = "1,2,3,4,5,46";

        assertThatThrownBy(() -> new Lotto(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Lotto_크기가_5일_때_예외_처리")
    @Test
    public void model_Lotto_size_5() {
        String inputLotto = "1,2,3,4,5";

        assertThatThrownBy(() -> new Lotto(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SIZE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Lotto_값이_중복일_때_예외_처리")
    @Test
    public void model_Lotto_duplicate() {
        String inputLotto = "1,2,3,4,5,5";

        assertThatThrownBy(() -> new Lotto(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_IS_DUPLICATE.getMessage());
    }

    @DisplayName("model_Lotto_크기가_6이고_범위가_올바를_때")
    @Test
    public void model_Lotto_size_6_and_correct_range() {
        String inputLotto = "1,2,3,4,5,6";
        Lotto lotto = new Lotto(inputLotto);

        assertThat(lotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }
}
