package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

class LottosTest {

    @DisplayName("로또 리스트를 올바르게 생성하는지 확인한다.")
    @Test
    void lottosShouldContainCorrectLottoEntries() {

        List<Lotto> testLottos = new ArrayList<>();
        testLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        testLottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        Lottos lottos = new Lottos(testLottos);

        assertEquals(testLottos, lottos.getLottos());
    }
}

