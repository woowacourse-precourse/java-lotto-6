package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @DisplayName("로또를 6개 생성한다.")
    @Test
    void generateLottoSix() {
        List<Lotto> lottos = new Game().issueLottos(10);
        assertThat(lottos.size()).isEqualTo(10);
    }
}
