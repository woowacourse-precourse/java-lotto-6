package lotto.domain;

import lotto.Error;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BuyLottoTest {
    @Test
    @DisplayName("구매 로또가 비어있다면 예외가 발생한다.")
    void 빈_구매_로또_예외_발생() {
        Assertions.assertThatThrownBy(()
                        -> new BuyLotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.Domain.EMPTY_LOTTO.getText());
    }

    @Test
    @DisplayName("구매 로또가 비어있지 않다면 예외가 발생하지 않는다.")
    void 구매_로또_예외_발생X() {
        new BuyLotto(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }
}