package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("로또 번호와 보너스 번호 매칭 유무에 따른 상금 테스트")
    @Test
    public void testGetPrize() {
        assertThat(Rank.valueOf(6, false).getPrize()).isEqualTo(2000000000);
        assertThat(Rank.valueOf(5, true).getPrize()).isEqualTo(30000000);
        assertThat(Rank.valueOf(5, false).getPrize()).isEqualTo(1500000);
        assertThat(Rank.valueOf(4, false).getPrize()).isEqualTo(50000);
        assertThat(Rank.valueOf(3, false).getPrize()).isEqualTo(5000);
    }
}