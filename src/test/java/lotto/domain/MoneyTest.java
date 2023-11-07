package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.exception.MoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[단위 테스트] 구입 금액")
class MoneyTest {

    @DisplayName("정상 상황일 때 구입 금액을 담당하는 클래스가 생성된다.")
    @Test
    void create_money() {
        // given
        int amount = 1000;

        // when
        Money money = new Money(amount);

        // then
        assertAll(
                () -> assertThatCode(() -> new Money(amount)).doesNotThrowAnyException(),
                () -> assertThat(money).isNotNull()
        );
    }

    @DisplayName("구입 금액이 정상 범위가 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -999, 0, 1, 999})
    void throw_exception_when_invalid_range(int input) {
        // when & then
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyException.INVALID_RANGE.getMessage());
    }

    @DisplayName("금액이 1000 단위가 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 1500})
    void throw_exception_when_invalid_unit(int input) {
        // when & then
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyException.INVALID_UNIT.getMessage());
    }
}
