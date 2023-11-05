package lotto.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("정상 동작 테스트")
    @Test
    void ok() {
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();
        LottoGenerator.generate(lottoNumberGenerator, 8);
    }
}