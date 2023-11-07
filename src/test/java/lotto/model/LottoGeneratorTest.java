package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    @DisplayName("랜덤한 6자리 로또 번호가 생성되는지 확인")
    void generateLotto() {
        Lotto lotto = lottoGenerator.generate();
        assertEquals(6, lotto.getNumbers().size());
    }
}