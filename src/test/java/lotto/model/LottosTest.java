package lotto.model;

import static lotto.constant.ErrorMessage.CONTAINING_OTHER_THAN_NUMBER;
import static lotto.constant.ErrorMessage.NOT_IN_LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.stub.LottosStub;
import org.junit.jupiter.api.Test;

class LottosTest extends LottosStub {
    @Test
    void from() {
        Lottos lottos = Lottos.from(QUANTITY);
        assertThat(lottos)
                .isInstanceOf(Lottos.class);
    }

    @Test
    void throw_exception_if_bonus_number_is_not_number() {
        Lottos lottos = Lottos.from(QUANTITY1);
        assertThatThrownBy(() -> lottos.getWinningResult(INT_WINNING_NUMBER, BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTAINING_OTHER_THAN_NUMBER.getMessage());
    }

    @Test
    void throw_exception_if_bonus_number_is_not_in_lotto_number_range() {
        Lottos lottos = Lottos.from(QUANTITY2);
        assertThatThrownBy(() -> lottos.getWinningResult(INT_WINNING_NUMBER1, BONUS_NUMBER1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_IN_LOTTO_NUMBER_RANGE.getMessage());
    }
}