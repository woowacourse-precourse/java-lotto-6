package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("로또 구매 수량과 lottos의 크기가 같아야 한다.")
    @Test
    void testCreateValidLottos() {
        int quantity = 3;
        Lottos lottos = new Lottos(quantity);

        assertThat(lottos.getLottos().size()).isEqualTo(quantity);
    }
}
