package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class QuantityTest {

    @DisplayName("값이 유효하면 객체를 생성한다.")
    @Test
    void should_CreateQuantity_When_Valid() {
        Quantity quantity = Quantity.of(new Money(1000), 1000);
        assertThat(quantity).isNotNull();
    }

    @DisplayName("돈이 유효하지 않은 갯수 객체는 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300, 400, 500, 600, 700, 800, 900, 999, 1255, 23567})
    void should_CreateQuantity_When_WrongBudget(int budget) {
        assertThatThrownBy(() -> Quantity.of(new Money(budget), 1000))
                .isInstanceOf(LottoException.class).hasMessageContaining("[ERROR]");
    }

    @DisplayName("구매한도(100000원) / 1000을 넘는 갯수(100개)는 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000000, 2000000, 3000000, 4000000, 5000000})
    void should_CreateQuantity_When_WrongAmount(int budget) {
        assertThatThrownBy(() -> Quantity.of(new Money(budget), 1000))
                .isInstanceOf(LottoException.class).hasMessageContaining("[ERROR] 최대 구매 한도를 초과했습니다.");
    }

}
