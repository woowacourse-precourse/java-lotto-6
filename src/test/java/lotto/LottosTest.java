package lotto;

import lotto.domain.Lottos;
import lotto.service.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottosTest {
    @DisplayName("로또 6개 저장 시 로또의 개수는 6개여야 한다.")
    @Test
    void saveLottoInLottosAndCorrectSize() {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator(6000);
        Lottos lottos = randomLottoGenerator.generate();

        assertEquals(6, lottos.getLength());
    }
}
