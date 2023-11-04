package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1000,2000,3000})
    @DisplayName("정상값 입력시 돈 제대로 반환하는지 테스트")
    void 돈_반환_테스트(int input) {

        Money money = new Money(input);
        Assertions.assertThat(money.getMoney())
                .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,900,999})
    @DisplayName("1000원 미만의 돈디 예외처리가 되는지 테스트")
    void 돈_범위_예외처리(int input) {

        Assertions.assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 이상 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1001,1010,1100})
    @DisplayName("1000원 단위가 아닌 돈이 예외처리가 되는지 테스트")
    void 돈_단위_예외처리(int input) {

        Assertions.assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 단위의 돈을 입력 해야 합니다.");
    }
}
