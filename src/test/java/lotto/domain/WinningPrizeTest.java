package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningPrizeTest {
    @DisplayName("매칭된 숫자 개수에 맞는 상금을 반환.")
    @Test
    void calculatePrice() {
        assertThat(WinningPrize.calculatePrize(6, true)).isEqualTo(2_000_000_000);
    }

    @DisplayName("매칭 개수가 5개이고 보너스 넘버가 포함되어 있을 때 2등 상금 반환.")
    @Test
    void calculatePriceByFiveWithBonusNumber() {
        assertThat(WinningPrize.calculatePrize(5, true)).isEqualTo(30_000_000);
    }

    @DisplayName("매칭된 숫자 개수에 맞는 상금을 반환.")
    @Test
    void calculatePriceByOutOfRangeMatchingNumber() {
        assertThatThrownBy(() -> WinningPrize.calculatePrize(2, false))
                .isInstanceOf(IllegalArgumentException.class);
    }
}