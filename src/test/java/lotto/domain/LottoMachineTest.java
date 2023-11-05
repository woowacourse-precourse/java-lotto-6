package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 500, 999, 1001})
    void 로또_구매_금액이_1000원_단위가_아니라면_예외를_발생시킨다(int money) {
        // given
        Money purchaseMoney = new Money(money);
        LottoMachine lottoMachine = new LottoMachine();

        // when & then
        assertThatThrownBy(() -> lottoMachine.purchaseLotto(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구매 금액은 1,000원 단위여야 합니다.");
    }
}
