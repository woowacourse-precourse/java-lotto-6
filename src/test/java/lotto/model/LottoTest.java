package lotto.model;

import static lotto.Message.ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.LOTTO_NUMBER_IS_DUPLICATE;
import static lotto.Message.ErrorMessage.VALUE_IS_NOT_CONVERT_INTEGER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("model_Lotto_k2가_입력_했을_때")
    @Test
    public void mode_Lotto_k2_input() {
        String inputWinningLotto = "1,k2,3,4,6,7";

        assertThatThrownBy(() -> new Lotto(inputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALUE_IS_NOT_CONVERT_INTEGER.getMessage());
    }

    @DisplayName("model_Lotto_빈문자열이_입력_했을_때")
    @Test
    public void mode_Lotto_empty_input() {
        String inputWinningLotto = "1,,3,4,6,7";

        assertThatThrownBy(() -> new Lotto(inputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALUE_IS_NOT_CONVERT_INTEGER.getMessage());
    }

    @DisplayName("model_Lotto_공백이_입력_했을_때")
    @Test
    public void mode_Lotto_blank_input() {
        String inputWinningLotto = "1, ,3,4,6,7";

        assertThatThrownBy(() -> new Lotto(inputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALUE_IS_NOT_CONVERT_INTEGER.getMessage());
    }

    @DisplayName("model_Lotto_1_미만이_입력_했을_때")
    @Test
    public void model_Lotto_1_under_input() {
        String inputWinningLotto = "0,2,3,4,5,6";

        assertThatThrownBy(() -> new Lotto(inputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Lotto_45_초과가_입력_했을_때")
    @Test
    public void model_Lotto_45_over_input() {
        String inputWinningLotto = "1,2,3,4,5,46";

        assertThatThrownBy(() -> new Lotto(inputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Lotto_크기가_5일_때_예외_처리")
    @Test
    public void model_Lotto_size_5() {
        String inputWinningLotto = "1,2,3,4,5";

        assertThatThrownBy(() -> new Lotto(inputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SIZE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Lotto_값이_중복일_때_예외_처리")
    @Test
    public void model_Lotto_duplicate() {
        String inputWinningLotto = "1,2,3,4,5,5";

        assertThatThrownBy(() -> new Lotto(inputWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_IS_DUPLICATE.getMessage());
    }

    @DisplayName("model_Lotto_크기가_6이고_범위가_올바를_때")
    @Test
    public void model_Lotto_size_6_and_correct_range() {
        String inputWinningLotto = "1,2,3,4,5,6";
        Lotto lotto = new Lotto(inputWinningLotto);

        assertThat(lotto.getWinningNumbers()).contains(1, 2, 3, 4, 5, 6);
    }
}
