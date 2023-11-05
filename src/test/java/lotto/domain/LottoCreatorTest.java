package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCreatorTest {

    @Test
    void Null값이_들어오면_IAE() {
        assertThrows(IllegalArgumentException.class, () -> new LottoCreator(null));
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 10})
    void 로또생성개수를_받으면_로또번호를_생성한다(int lottoCount) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoCreator lottoCreator = new LottoCreator(lottoNumberGenerator);
        assertEquals(lottoCount, lottoCreator.createLottos(lottoCount).size());
    }

}