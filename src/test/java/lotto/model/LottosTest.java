package lotto.model;

import static lotto.constant.ErrorMessage.CONTAINING_OTHER_THAN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void from() {
        int quantity = 5;
        Lottos lottos = Lottos.from(quantity);
        assertThat(lottos)
                .isInstanceOf(Lottos.class);
    }

    @Test
    void throw_exception_if_bonus_number_is_not_number() {
        int quantity = 5;
        String intWinningNumber = "1,2,3,4,5,6";
        Lottos lottos = Lottos.from(quantity);
        String bonusNumber = "7?";
        assertThatThrownBy(() -> lottos.getWinningResult(intWinningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTAINING_OTHER_THAN_NUMBER.getMessage());
    }

    @Test
    void throw_exception_if_bonus_number_is_not_in_lotto_number_range() {
        int quantity = 5;
        String intWinningNumber = "1,2,3,4,5,6";
        Lottos lottos = Lottos.from(quantity);
        String bonusNumber = "0";
        assertThatThrownBy(() -> lottos.getWinningResult(intWinningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTAINING_OTHER_THAN_NUMBER.getMessage());
    }
}