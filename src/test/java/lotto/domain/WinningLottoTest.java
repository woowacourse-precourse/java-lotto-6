package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void createWinningLottos_호출시_로또객체를_반환한다() {
        // given
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        // when
        WinningLotto result = WinningLotto.createWinningLottos(expected);
        // then
        assertThat(result.getLotto()).isEqualTo(expected);
    }

}