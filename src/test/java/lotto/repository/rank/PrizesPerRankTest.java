package lotto.repository.rank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizesPerRankTest {

    @DisplayName("등수를 입력하면 그에 맞는 상금을 알려줍니다.")
    @ParameterizedTest
    @CsvSource(value = {"5,5000","4,50000","3,1500000","2,30000000","1,2000000000"})
    void getPrizeBy(int rank, int prize) {
        // when
        PrizesPerRank.create();
        // then
        Assertions.assertThat(PrizesPerRank.getPrizeBy(rank)).isEqualTo(prize);
    }
}