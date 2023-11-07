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

    @DisplayName("로또들의 로또 번호들을 정상적으로 반환한다.")
    @Test
    void getLottosNumbers() {
        List<Lotto> severalLottos = new ArrayList<>(
            List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7))));
        Lottos lottos = new Lottos(severalLottos);

        List<List<Integer>> expectedLottosNumbers = new ArrayList<>(
            List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7)));

        List<List<Integer>> actualLottosNumbers = lottos.getLottosNumbers();

        assertEquals(expectedLottosNumbers, actualLottosNumbers);
    }
}