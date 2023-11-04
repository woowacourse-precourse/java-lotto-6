package lotto.model;

import static lotto.Message.ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

class LottoTest {
    @DisplayName("model_Lotto_1_미만이_입력_했을_때")
    @Test
    public void model_Lotto_1_under_input() {
        List<Integer> inputAmount = Arrays.asList(0, 2 ,3, 4, 5, 6);

        assertThatThrownBy(() -> new Lotto(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Lotto_45_초과가_입력_했을_때")
    @Test
    public void model_Lotto_45_over_input() {
        List<Integer> inputAmount = Arrays.asList(1, 2 ,3, 4, 5, 46);

        assertThatThrownBy(() -> new Lotto(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Lotto_크기가_5일_때")
    @Test
    public void model_Lotto_size_5() {
        List<Integer> inputAmount = Arrays.asList(1, 2 ,3, 4, 5);

        assertThatThrownBy(() -> new Lotto(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SIZE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Lotto_크기가_6이고_범위가_올바를_때")
    @Test
    public void model_Lotto_size_6_and_collect_range() {
        List<Integer> inputAmount = Arrays.asList(1, 2 ,3, 4, 5, 6);
        Lotto lotto = new Lotto(inputAmount);

        assertThat(lotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
                ;
    }
}
