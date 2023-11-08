package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 10})
    void 수량을_입력하면_랜덤_로또_n개_생성(int input) {
        Lottos randomLottos = Lottos.createRandomLottos(input);
        
        assertThat(randomLottos.getLottos().size()).isEqualTo(input);
    }

    @Test
    void 게임_결과_정상_생성_확인() {
        WinningInfo winningInfo = WinningInfo.create(List.of(1, 2, 3, 4, 5, 6), 7);
        Lottos randomLottos = Lottos.createRandomLottos(5);

        assertThat(randomLottos.getGameResult(winningInfo)).isInstanceOf(GameResult.class);
    }
}