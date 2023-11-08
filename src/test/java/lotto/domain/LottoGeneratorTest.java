package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("로또 무작위 번호 생성 성공")
    @Test
    void createLottoTest() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = new Lotto(lottoGenerator.getRandomNumbers());

        assertEquals(lottoGenerator.getRandomNumbers(), lotto.getNumbers());
    }

}