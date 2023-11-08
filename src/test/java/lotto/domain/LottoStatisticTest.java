package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticTest {
    @DisplayName("로또 통계 생성 테스트")
    @Test
    void getLottoStatisticTest() {
        List<LottoResult> lottoResults = IntStream.range(0, 10)
                .mapToObj(i -> new LottoResult(6, false))
                .toList();
        LottoStatistic lottoStatistic = new LottoStatistic(lottoResults);

        assertThat(lottoStatistic.getLottoStatistic())
                .containsOnlyKeys(new LottoResult(6, false));
    }
}
