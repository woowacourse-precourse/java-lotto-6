package lotto;

import java.util.List;
import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
    @DisplayName("로또 여러개 생성 시 카운트 일치 테스트")
    @Test
    void createLottos_CountEqual_Succes() {
        Game game = new Game();
        Lottos lottos = game.createLottos(6);

        assertThat(lottos.getLottos().size()).isEqualTo(6);

    }


}
