package lotto.domain;

import lotto.policy.NumberGeneratePolicy;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)

class LottoNumberGeneratorTest {

    @Test
    void 로또_장수_만큼_로또를_생성해_반환한다() {
        // given
        NumberGeneratePolicy numberGeneratePolicy = () -> List.of(1, 2, 3, 4, 5, 6);
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(numberGeneratePolicy);
        int lottoCount = 10;

        // when
        List<Lotto> lottos = lottoNumberGenerator.generate(lottoCount);

        // then
        assertThat(lottos).hasSize(lottoCount);
    }

}
