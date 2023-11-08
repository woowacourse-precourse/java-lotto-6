package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.player.BuyLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BuyTest {
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"500a", "천 원", "1장"})
    void createPurchaseAmountByNaN(String amount) {
        assertThatThrownBy(() -> new BuyLotto(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"500", "1900", "1000.4", "-1000.4"})
    void createPurchaseAmountIndivisibleBy1000(String amount) {
        assertThatThrownBy(() -> new BuyLotto(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("구입 금액이 '-3,000'과 같은 음수이거나 0이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "-4000"})
    void createPurchaseAmountByNonPositiveInteger(String amount) {
        assertThatThrownBy(() -> new BuyLotto(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 구입 금액은 1,000원입니다.");
    }

}
