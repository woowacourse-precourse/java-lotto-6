package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 결과 테스트")
class LottoResultTest {

    @DisplayName("등수를 전달하여 해당 등수의 로또가 몇개인지 얻어낼 수 있다.")
    @Test
    void testCountsByRank() {
        EnumMap<LottoRank, Integer> countByRanks = new EnumMap<>(LottoRank.class);
        countByRanks.put(LottoRank.FIRST, 2);
        LottoResult result = LottoResult.from(countByRanks);
        assertThat(result.getCountByRank(LottoRank.FIRST)).isEqualTo(2);
    }
}