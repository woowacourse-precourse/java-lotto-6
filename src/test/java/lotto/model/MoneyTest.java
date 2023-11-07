package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("구입 금액이 0원이하일 경우 예외 발생")
    @Test
    void createMoneyLessThanZero() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 0원보다 많아야 합니다.");
    }

    @DisplayName("구매 금액이 1000원 단위가 아닌 경우 예외 발생")
    @Test
    public void createMoneyNotDividedByThousand() {
        assertThatThrownBy(() -> new Money(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("Money 객체 생성 성공 후 구매한 로또 개수 반환 성공")
    @Test
    public void createMoney() {
        //given
        int validAmount = 2000;

        //when
        Money money = new Money(validAmount);
        int lottoCount = money.getLottoCount();

        //then
        Assertions.assertThat(lottoCount).isEqualTo(2);
    }
}
