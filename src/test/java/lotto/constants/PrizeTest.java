package lotto.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @DisplayName("당첨 등수 계산")
    @Test
    void rank(){
        assertThat(Prize.rank(6,false)).isEqualTo(Prize.FIRST);

        assertThat(Prize.rank(5,true)).isEqualTo(Prize.SECOND);
        assertThat(Prize.rank(5,false)).isEqualTo(Prize.THIRD);

        assertThat(Prize.rank(4,true)).isEqualTo(Prize.FOURTH);
        assertThat(Prize.rank(4,false)).isEqualTo(Prize.FOURTH);

        assertThat(Prize.rank(3,true)).isEqualTo(Prize.FIFTH);
        assertThat(Prize.rank(3,false)).isEqualTo(Prize.FIFTH);
    }

}