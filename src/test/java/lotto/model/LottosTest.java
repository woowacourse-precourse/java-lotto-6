package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottosTest {

    @DisplayName("생성 테스트 : List<Lotto>를 갖는 Lottos 객체를 생성한다.")
    @Test
    void create() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);

        assertThatCode(() -> new Lottos(lottos))
                .doesNotThrowAnyException();
    }
}