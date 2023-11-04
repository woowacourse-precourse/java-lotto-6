package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.strategy.AutoIssueStrategy;

class LottosTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {1, 10, 100})
    @DisplayName("로또 여러 개 생성")
    void givenTotalCount_whenCreateLottos_thenReturn(int totalCount) {
        // when
        Lottos lottos = new Lottos(totalCount, new AutoIssueStrategy());

        // then
        assertThat(lottos.count()).isEqualTo(totalCount);
    }

}
