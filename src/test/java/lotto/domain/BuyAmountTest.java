package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BuyAmountTest {

    @ParameterizedTest(name = "입력 금액 : {0}")
    @ValueSource(ints = {123456, 234567, 34567})
    @DisplayName("1000원으로 나누어 떨어지지 않는 금액 입력 시 예외가 발생한다.")
    void 구매금액_입력_예외_테스트(int amount) {
        //when, then
        Assertions.assertThatThrownBy(() -> new BuyAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원으로");
    }

}
