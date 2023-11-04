package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {
    @DisplayName("특정 개수 만큼 로또를 발행한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 222})
    void createTest(int count) {
        // given
        Lottos lottos = new Lottos(new RandomNumbers());

        // when
        List<Lotto> lottoList = lottos.generate(count);

        // then
        assertThat(lottoList).hasSize(count);
    }
}
