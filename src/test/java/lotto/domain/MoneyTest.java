package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {8000, 1000, 50000})
    void money를_주면_Money객체를_생성(int money) {
        // when
        Money result = Money.from(money);
        // then
        assertThat(result).isInstanceOf(Money.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {808, 10001, 5030})
    void money가_1000원단위_아닐경우_예외를반환(int money) {
        assertThatThrownBy(() -> Money.from(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {808, 11, 0})
    void money로_로또1개도_구입못하면_예외반환(int money) {
        assertThatThrownBy(() -> Money.from(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}