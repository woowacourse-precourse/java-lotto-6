package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    @DisplayName("구매 금액이 로또 가격에 나누어 떨지지 않거나 0원이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1234, 0})
    void createLottoByOverSize(int purchaseAmount) {
        assertThatThrownBy(() -> new LottoMachine().issueLottos(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }
}
