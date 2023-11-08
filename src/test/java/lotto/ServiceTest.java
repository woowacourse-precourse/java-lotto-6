package lotto;

import lotto.domain.Lotto;
import lotto.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ServiceTest {

    @DisplayName("makeLottos() 테스트")
    @Test
    void makeLottosNormal() {
        // given
        int buyCount = 5;
        GameService gameService = new GameService();

        // when
        List<Lotto> lottos = gameService.makeLottos(5);

        // then
        assertThat(lottos.size()).isEqualTo(buyCount);
    }
}
