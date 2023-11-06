package lotto;

import lotto.Model.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("랜덤 로또가 개수대로 잘 생성 되는지 테스트")
    @Test
    void createLottos() {
        Lottos lottos = new Lottos(3);

        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(3);
    }
}
