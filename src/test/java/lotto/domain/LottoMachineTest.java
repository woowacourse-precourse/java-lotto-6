package lotto.domain;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 8})
    @DisplayName("수량만큼 로또 발행 성공")
    void createLottos(int count) {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        // when
        List<Lotto> lottos = lottoMachine.createAllLotto(count);

        // then
        assertThat(lottos.size()).isEqualTo(count);
    }
}
