package lotto.domain;

import lotto.infra.LottoNumberGeneratorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGeneratorImpl();

    @Test
    @DisplayName("로또 생성 되는지 테스트")
    public void testGenerateLotto() {
        Assertions.assertDoesNotThrow(() -> lottoNumberGenerator.generateLotto());
    }
}
