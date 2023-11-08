package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @Test
    public void generateLottoNumbersByRandom_size_test() {
        // given
        int count = 8;

        // when
        List<Lotto> result = LottoGame.generateLottoNumbersByRandom(count);

        // then
        assertEquals(result.size(), count);
    }
}