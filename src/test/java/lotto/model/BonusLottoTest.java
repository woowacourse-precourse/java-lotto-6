package lotto.model;

import static lotto.Message.ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.BONUS_NUMBER_IS_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class BonusLottoTest {
    @DisplayName("model_BonusLotto_0이_입력_했을_때_예외_처리")
    @Test
    public void model_BonusLotto_0_input() {
        int inputBonus = 0;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 6, 15);

        assertThatThrownBy(() -> new BonusLotto(inputBonus, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_BonusLotto_45_초과가_입력_했을_때_예외_처리")
    @Test
    public void model_BonusLotto_45_over_input() {
        int inputBonus = 46;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 6, 15);

        assertThatThrownBy(() -> new BonusLotto(inputBonus, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_BonusLotto_중복될_때_예외_처리")
    @Test
    public void model_BonusLotto_duplicate() {
        int inputBonus = 2;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 6, 15);

        assertThatThrownBy(() -> new BonusLotto(inputBonus, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_IS_DUPLICATE.getMessage());
    }

    @DisplayName("model_BonusLotto_범위가_올바를_때")
    @Test
    public void model_BonusLotto_correct_range() {
        int inputBonus = 2;
        List<Integer> winningNumbers = Arrays.asList(1, 14, 3, 4, 6, 15);
        BonusLotto bonusLotto = new BonusLotto(inputBonus, winningNumbers);

        assertThat(bonusLotto.getBonusNumber()).isEqualTo(2);
    }
}
