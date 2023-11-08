package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("Lottos 생성 테스트")
    void createLottos() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        assertThat(lottos.getLottoCollection()).contains(lotto1, lotto2);
    }

}