package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AutoLottosTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void createAutoLottos는_주어진수만큼_로또를_생성(int count) {
        AutoLottos autoLottos = new AutoLottos();
        autoLottos.createAutoLottos(count, new LottoGenerator());
        assertThat(autoLottos.getLottos().size()).isEqualTo(count);
    }

}