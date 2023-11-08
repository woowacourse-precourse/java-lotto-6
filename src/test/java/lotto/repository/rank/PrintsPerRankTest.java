package lotto.repository.rank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrintsPerRankTest {

    @DisplayName("등수를 입력하면 그에 맞는 출력값을 알려줍니다.")
    @ParameterizedTest
    @CsvSource(value = {"5:3개 일치","4:4개 일치","3:5개 일치","2:5개 일치, 보너스 볼 일치","1:6개 일치"},delimiter = ':')
    void getPrintBy(int rank, String result) {
        // when
        PrintsPerRank.create();
        // then
        Assertions.assertThat(PrintsPerRank.getPrintBy(rank)).contains(result);
    }
}