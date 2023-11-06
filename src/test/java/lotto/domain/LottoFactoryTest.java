package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @Test
    @DisplayName("create는 NumberGenerator를 통해 로또를 생성한다.")
    void create() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        NumberGenerator generator = (minInclusive, maxInclusive, size) -> lottoNumbers;
        LottoFactory lottoFactory = new LottoFactory(generator);

        // when
        Lotto lotto = lottoFactory.create();

        // then
        LottoMatchResult result = lotto.compare(lottoNumbers, 7);
        assertThat(result.matchCount()).isEqualTo(lottoNumbers.size());
    }
}