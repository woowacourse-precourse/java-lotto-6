package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class RankTest {
    @Test
    void 올바른_상수를_반환하는지_확인(){
        Rank secondPlace = Rank.getRank(5,1);
        Assertions.assertThat(secondPlace).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    void 적절한_상태를_반환하는지_확인(){
        Rank secondPlace = Rank.getRank(5,1);

        String status = secondPlace.getStatus();

        Assertions.assertThat(status).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
    }
}