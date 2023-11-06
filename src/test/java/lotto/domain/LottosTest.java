package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("여러개의 로또로 로또들을 정상적으로 생성한다.")
    @Test
    void createLottosBySeveralLottos() {
        List<Lotto> severalLottos = new ArrayList<>(
            List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7))));

        Lottos lottos = new Lottos(severalLottos);

        assertNotNull(lottos);
        assertEquals(severalLottos, lottos.getLottos());
    }
}