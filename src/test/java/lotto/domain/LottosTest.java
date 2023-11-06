package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottosTest {

    @DisplayName("로또를 여러개 생성 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 8})
    public void generateLottoMultipleTimes(Integer loop) {
        Lottos lottos = Lottos.from(loop);

        assertThat(lottos.getList())
                .hasSize(loop)
                .doesNotContainNull();
    }

}
