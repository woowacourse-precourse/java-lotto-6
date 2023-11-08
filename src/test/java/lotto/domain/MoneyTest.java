package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("값이 유효하면 객체를 생성한다.")
    @Test
    void should_CreateMoney_When_Valid() {
        Money money = new Money(100000);
        assertThat(money).isNotNull();
    }

    @DisplayName("구매한도를 초과한 경우 예외가 발생한다.")
    @Test
    void should_Throw_Exception_When_ValueIsGreaterThanLimit() {
        assertThatThrownBy(() -> new Money(1000001))
                .isInstanceOf(LottoException.class).hasMessageContaining("[ERROR] 최대 구매 한도를 초과했습니다.");
    }

    @DisplayName("로또 한장의 가격보다 돈이 부족할 때 예외가 발생한다.")
    @Test
    void should_Throw_Exception_When_LowerThanPrice() {
        assertThatThrownBy(() -> new Money(999))
                .isInstanceOf(LottoException.class).hasMessageContaining("[ERROR] 돈이 모자랍니다.");
    }

    @DisplayName("1000으로 나눌 수 없는경우 예외가 발생한다.")
    @Test
    void should_Throw_Exception_When_IndivisibleBy1000() {
        assertThatThrownBy(() -> new Money(1569))
                .isInstanceOf(LottoException.class).hasMessageContaining("[ERROR] 올바른 단위의 수가 아닙니다.");
    }

}
