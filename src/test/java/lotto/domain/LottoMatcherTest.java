package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class LottoMatcherTest {

    @Test
    public void 구매한_로또의_결과를_확인한다() throws Exception {
        //given
        LottoMatcher lottoMatcher = new LottoMatcher(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 7, 5, 6));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 6));

        //when
        Map<LottoResult, Integer> counter = lottoMatcher.match(List.of(lotto1, lotto2, lotto3));

        //then
        Assertions.assertThat(counter.get(LottoResult.of(1))).isEqualTo(1);
        Assertions.assertThat(counter.get(LottoResult.of(2))).isEqualTo(1);
        Assertions.assertThat(counter.get(LottoResult.of(3))).isEqualTo(1);
    }

}