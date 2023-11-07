package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {

    @DisplayName("1000원 이상의 금액으로 돈 객체가 생성된다.")
    @Test
    void createMoneyTest() {
        // given
        int input = 1000;

        // when
        Money money = Money.of(input);

        // then
        assertThat(money).isNotNull();
        Assertions.assertThat(money.money()).isEqualTo(input);
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 금액의 경우 예외가 발생한다.")
    @Test
    void createMoneyByNotMultiplyOfLottoPerPrice() {
        // given
        int input = 2455;

        // when & then
        Assertions.assertThatThrownBy(() -> Money.of((input)))
                .hasMessage("[ERROR] 1000원 단위로 입력해주세요.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 미만의 금액으로 돈 객체를 생성하면 예외가 발생한다.")
    @Test
    void createMoneyByLessThan1000Test() {
        // given
        int input = 999;

        // when & then
        Assertions.assertThatThrownBy(() -> Money.of(input))
                .hasMessage("[ERROR] 1000원 이상의 금액을 입력해주세요.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수의 금액으로 돈 객체를 생성하면 예외가 발생한다.")
    @Test
    void createMoneyByNegativeNumberTest() {
        // given
        int input = -1000;

        // when & then
        Assertions.assertThatThrownBy(() -> Money.of(input))
                .hasMessage("[ERROR] 1000원 이상의 금액을 입력해주세요.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("현재 돈으로 발행 가능한 로또 수를 계산할 수 있다.")
    @Test
    void calculateGenerateLottosTest() {
        // given
        int input = 4000;
        Money money = Money.of(input);

        // when
        int result = money.calculateNumberOfLotto();

        //then
        Assertions.assertThat(result).isEqualTo(input / NumberConstraints.LOTTO_PER_PRICE.value());
    }
}
