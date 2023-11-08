package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @DisplayName("BounsNumber를 제외하고 맞은 개수에 따른 Prize를 생성한다.")
    @Test
    void createPrize_By_MatchCount() {
        assertEquals(2000000000, Prize.of(6, false).getPrizeMoney());
    }

    @DisplayName("BounsNumber를 포함하여 맞은 개수에 따른 Prize를 생성한다.")
    @Test
    void createPrize_By_MatchCount_With_BonusNumber() {
        assertEquals(30000000, Prize.of(5, true).getPrizeMoney());
    }

    @DisplayName("맞은 갯수가 범위보다 작은 경우 예외가 발생한다.")
    @Test
    void createPrize_By_LowerMatchCount_Exception() {
        assertThatThrownBy(() -> Prize.of(2, false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("맞은 갯수가 범위보다 큰 경우 예외가 발생한다.")
    @Test
    void createPrize_By_OverMatchCount_Exception() {
        assertThatThrownBy(() -> Prize.of(7, false))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
