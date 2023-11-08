package lotto.model;

import static lotto.Message.ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.BONUS_NUMBER_IS_DUPLICATE;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BonusLottoTest {
    private static List<Integer> winningNumbers;

    @DisplayName("model_BonusLott_초기화")
    @BeforeAll
    static void model_BonusLotto_initialize() {
        winningNumbers = Arrays.asList(1, 2, 3, 4, 6, 15);
    }

    @DisplayName("model_BonusLotto_0이_입력_했을_때_예외_처리")
    @Test
    void model_BonusLotto_0_input() {
        int inputBonus = 0;

        assertThatThrownBy(() -> new BonusLotto(inputBonus, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_BonusLotto_45_초과가_입력_했을_때_예외_처리")
    @Test
    void model_BonusLotto_45_over_input() {
        int inputBonus = 46;

        assertThatThrownBy(() -> new BonusLotto(inputBonus, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_BonusLotto_중복될_때_예외_처리")
    @Test
    void model_BonusLotto_duplicate() {
        int inputBonus = 2;

        assertThatThrownBy(() -> new BonusLotto(inputBonus, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_IS_DUPLICATE.getMessage());
    }

    @DisplayName("model_BonusLotto_범위가_올바를_때")
    @Test
    void model_BonusLotto_correct_range() {
        int inputBonus = 5;
        BonusLotto bonusLotto = new BonusLotto(inputBonus, winningNumbers);

        assertThat(bonusLotto.getBonusNumber()).isEqualTo(5);
    }
}
