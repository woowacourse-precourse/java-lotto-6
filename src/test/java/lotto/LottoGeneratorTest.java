package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LottoGeneratorTest {
    @DisplayName("로또 생성기 테스트 하기")
    @Test
    void testGenerateLottos() {
        // given
        int userMoney = 5000;
        int lottoPirce = 1000;
        int numberOfLottos = userMoney / lottoPirce;
        // when
        List<Lotto> lottos = LottoGenerator.generateLottos(numberOfLottos);
        // then
        assertNotNull(lottos);
        assertEquals(numberOfLottos, lottos.size());

        for (Lotto lotto : lottos) {
            assertNotNull(lotto);
            assertEquals(6, lotto.getLottoNumbers().size());
        }
    }
}
