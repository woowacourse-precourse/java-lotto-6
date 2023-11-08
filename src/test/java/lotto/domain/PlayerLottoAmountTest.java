package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerLottoAmountTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000j", "1100", "-1"})
    @DisplayName("올바르지 않은 금액")
    void failed(String inputAmount) {
        assertThatThrownBy(() -> new PlayerLottoAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 로또 티켓 장수")
    void calculateLottoCount() {
        PlayerLottoAmount amount = new PlayerLottoAmount("1000");
        assertThat(amount.calculateLottoCount()).isEqualTo(1);
    }
}
