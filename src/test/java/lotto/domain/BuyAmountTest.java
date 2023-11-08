package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BuyAmountTest {

    @ParameterizedTest(name = "입력 금액 : {0}")
    @ValueSource(longs = {123456, 234567, 34567})
    @DisplayName("1000원으로 나누어 떨어지지 않는 금액 입력 시 예외가 발생한다.")
    void 구매금액_입력_예외_테스트(long amount) {
        //when, then
        Assertions.assertThatThrownBy(() -> new BuyAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원으로");
    }

    @ParameterizedTest(name = "입력 금액 : {0}, 기대 값 : {1}")
    @CsvSource(value = {"8000, 8", "9000, 9", "10000, 10"})
    @DisplayName("입력한 금액으로 구매할 수 있는 로또 개수를 반환한다.")
    void 구매_가능_로또_개수_테스트(long amount, int expected) {
        //given
        BuyAmount buyAmount = new BuyAmount(amount);

        //when
        int actual = buyAmount.getAbleToBuyCount();

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
