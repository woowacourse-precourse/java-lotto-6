package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeMoneyTest {

    @Test
    @DisplayName("PrizeMoney 열거형이 주어진 순서에 맞는 상금을 반환해야 함")
    void getPrizeMoneyByOrdinal() {
        assertThat(PrizeMoney.getByOrdinal(0).getPrizeMoneyValue()).isEqualTo(0);
        assertThat(PrizeMoney.getByOrdinal(3).getPrizeMoneyValue()).isEqualTo(5_000);
        assertThat(PrizeMoney.getByOrdinal(6).getPrizeMoneyValue()).isEqualTo(2_000_000_000);
        assertThat(PrizeMoney.getByOrdinal(7).getPrizeMoneyValue()).isEqualTo(30_000_000);
    }

    @Test
    @DisplayName("존재하지 않는 순서에 대한 PrizeMoney 열거형을 요청하면 예외가 발생해야 함")
    void getNonExistentPrizeMoney() {
        int invalidOrdinal = 8;
        assertThatThrownBy(() -> PrizeMoney.getByOrdinal(invalidOrdinal))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]" + invalidOrdinal);
    }

}
