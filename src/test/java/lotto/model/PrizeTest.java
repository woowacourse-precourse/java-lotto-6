package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void validateGetByMatchesAndBonus() {
        assertThat(Prize.getByMatchesAndBonus(6, false)).isEqualTo(Prize.FIRST_PRIZE);
        assertThat(Prize.getByMatchesAndBonus(5, true)).isEqualTo(Prize.SECOND_PRIZE);
        assertThat(Prize.getByMatchesAndBonus(5, false)).isEqualTo(Prize.THIRD_PRIZE);
        assertThat(Prize.getByMatchesAndBonus(4, false)).isEqualTo(Prize.FOURTH_PRIZE);
        assertThat(Prize.getByMatchesAndBonus(3, false)).isEqualTo(Prize.FIFTH_PRIZE);
        assertThat(Prize.getByMatchesAndBonus(2, false)).isEqualTo(Prize.NOTHING_PRIZE);
    }
}
